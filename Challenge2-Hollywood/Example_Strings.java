//UIUC CS125 SPRING 2017 MP. File: Example_Strings.java, CS125 Project: Challenge2-Hollywood, Version: 2017-02-07T20:36:02-0600.374213000
public class Example_Strings {

	/**
	 * Lecture 7 example.
	 */
	public static void main(String[] args) {
		boolean keepGoing = true;
		String user;
		while (keepGoing) {
			TextIO.putln("Enter a string with exactly 5 characters.");
			user = TextIO.getln();
			TextIO.put("You typed:"); // use put not putln
			TextIO.putln(user);

			if (user.length() == 5) {
				keepGoing = false;
			} else {
				TextIO.putln("Try again!");
			}
		} // while
		TextIO.putln("Yes!");

	}

}
