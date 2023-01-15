import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FindAverage {
	
	private static List<Integer> getIntegerArray(List<String> stringArray) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(String stringValue : stringArray) {
			try {
				// Convert String to Integer, and store it into integer array list.
				result.add(Integer.parseInt(stringValue.trim()));
			} catch(NumberFormatException nfe) {
				//System.out.println("Could not parse " + nfe)
				System.out.println("Parsing failed!" + stringValue + " can not be an integer");
			}
		}
		return result;
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String strLine = "";
		double avg = 0.0;
		List<String> list = new ArrayList<String>();
		List<Integer> intList = new ArrayList<Integer>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/andreamanisi/eclipse-workspace/FindAverage/testdata.txt"));
			while (strLine != null)
			{
				strLine = br.readLine();
				sb.append(strLine);
				if (strLine == null)
					break;
				list.add(strLine);
			}
			
				/*System.out.println(Arrays.toString(list.toArray()));*/
				list.remove(0);
				br.close();
				
				intList = getIntegerArray(list);
				int sum = intList.stream().mapToInt(Integer::valueOf).sum();
				avg = sum / 3;
				
				System.out.println("The exams average for the student is: " + avg);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("Unable to read the file.");
		}
	}
}