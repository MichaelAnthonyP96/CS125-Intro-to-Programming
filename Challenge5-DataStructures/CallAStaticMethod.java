//UIUC CS125 SPRING 2017 MP. File: CallAStaticMethod.java, CS125 Project: Challenge5-DataStructures, Version: 2017-03-07T20:15:59-0600.396489000
/**
 * Prints out only lines that contain an email address Each printed line is
 * justified to right by prepending the text with '.' characters The minimum
 * width of the line including padding is 40 characters. See the test case for
 * example input and expected output.
 * @author mapope2
 */
class CallAStaticMethod {

	public static void main(String[] args) {

		while (!TextIO.eof()) {
			String line = TextIO.getln();
			// Use ExampleClassMethods
			// 'isEmailAddress' and 'createPadding' to complete this method
			String newLine = "";
			if (ExampleClassMethods.isEmailAddress(line) && (line.indexOf(".") > 0)) {
				int number = (40 - line.length());
				newLine = ExampleClassMethods.createPadding('.', number) + line;
				TextIO.putln(newLine);
			}
		}

	}
}
