//UIUC CS125 SPRING 2017 MP. File: MovieSurvey.java, CS125 Project: Challenge2-Hollywood, Version: 2017-02-07T20:36:02-0600.374213000
/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author mapope2
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		// TODO: Write your program here
		TextIO.putln("Welcome. We\'re interested in how people are watching movies this year.");
		TextIO.putln("Thanks for your time. - The WRITERS GUILD OF AMERICA.");
		TextIO.putln("Please tell us about how you've watched movies in the last month.");
		TextIO.putln("How many movies have you seen at the cinema?");
		int cinema = TextIO.getlnInt();
		TextIO.putln("How many movies have you seen using a DVD or VHS player?");
		int player = TextIO.getlnInt();
		TextIO.putln("How many movies have you seen using a Computer?");
		int computer = TextIO.getlnInt();
		TextIO.putln("Summary: " + cinema + " Cinema movies, " + player + " DVD/VHS movies, " + computer + " Computer movies");
		int total = cinema + player + computer;
		TextIO.putln("Total: " + total + " movies");
		double percentage1;
		double percentage2;
		double cinema1 = (double) cinema;
		double player1 = (double) player;
		double computer1 = (double) computer;
		double total1 = (double) total;
		percentage1 = ((cinema1/total1)*100.0);
		percentage2 = ((player1+computer1)/total1)*100;
		System.out.print("Fraction of movies seen at a cinema: ");
		System.out.printf("%.2f", percentage1);
		System.out.println("%");
		System.out.print("Fraction of movies seen outside of a cinema: ");
		System.out.printf("%.2f", percentage2);
		System.out.print("%");
		// Hints :
		// Formatted output
		// http://math.hws.edu/javanotes/c2/s4.html#basics.4.4
		
		// Don't just copy paste the expected output
		// For grading purposes your code may be tested
		// with other input values.
	}
}
