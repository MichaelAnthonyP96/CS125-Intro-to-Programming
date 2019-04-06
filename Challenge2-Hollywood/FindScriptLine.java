/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author mapope2
 */
public class FindScriptLine {

	public static void main(String[] args) {
// TODO: Implement the functionality described in FindScriptLine.txt
// TODO: Test your code manually and using the automated unit tests in FindScriptLineTest
		String initialSearch = " ";
		String search = " ";
		String line = " ";
		int lineCount = 0;
		
		// Prompts the user and reads their response
		System.out.println("Please enter the word(s) to search for");
		initialSearch = TextIO.getln();
		search = initialSearch.toLowerCase();
		TextIO.readFile("thematrix.txt");
		
		//Alerts the user that we are searching for their string
		System.out.println("Searching for '" + initialSearch + "'");
		
		//while loop running through our file
		while(!TextIO.eof()) {
			String readLine = TextIO.getln();
			lineCount++;
			line = readLine.toLowerCase();
			if(line.contains(search)){
				TextIO.putln(lineCount + " - " + readLine.trim());
			}
		}
		TextIO.putln("Done Searching for '" + initialSearch + "'");
	}
}
