//UIUC CS125 SPRING 2017 MP. File: Factorial.java, CS125 Project: Challenge1-DebugMe, Version: 2017-02-03T03:20:37-0600.495048000

/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author mapope2
 */
public class Factorial {
	public static void main(String[] args) {
		long max = 0L;
		int temp = 0;
		
		while (max < 1 || max >= 21) {
			System.out.println("Enter a number between 1 and 20 inclusive.");
			max = TextIO.getlnInt();
		}
		temp = (int) max;
		int n = (int) (max-1);
		while (n > 0){
			max = (max*n);
			n = (n-1);
		}
		System.out.println(temp + "! = " + max);
	}
}
