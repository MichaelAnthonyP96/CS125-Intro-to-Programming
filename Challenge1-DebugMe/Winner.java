//UIUC CS125 SPRING 2017 MP. File: Winner.java, CS125 Project: Challenge1-DebugMe, Version: 2017-02-03T03:20:37-0600.495048000

/**
 * This program prints "a","b","c" depending on who has the highest score. The
 * given code may not be correct. Fix it and additional code to pass the unit
 * tests.
 * 
 * @see Winner-ReadMe.txt for details on how to complete this program.
 * @author mapope2
 * 
 */
public class Winner {
	public static void main(String[] args) {
		System.out.println("Enter three unique integer scores.");

		int a = TextIO.getlnInt();
		int b = TextIO.getlnInt();
		int c = TextIO.getlnInt();

		TextIO.put("1st Place:");
		if (a > b && a > c)
			TextIO.putln("a");
		if (b > a && b > c)
			TextIO.putln("b");
		if (c > a && c > b)
			TextIO.putln("c");
		// the logic and text output need further work...
	}
}