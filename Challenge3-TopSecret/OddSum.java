//UIUC CS125 SPRING 2017 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2017-02-14T21:53:35-0600.839381000
/**
 * Prints sum of odd numbers in a specific format. TODO: add your netid to the
 * line below
 * 
 * @author mapope2
 */
public class OddSum {
	/**
	 * Example output if user enters 10: Max? 1 + 3 + 5 + 7 + 9 = 25 25 = 9 + 7
	 * + 5 + 3 + 1
	 * 
	 * Example output if user enters 11: Max? 1 + 3 + 5 + 7 + 9 + 11 = 36 36 =
	 * 11 + 9 + 7 + 5 + 3 + 1
	 * 
	 * if (num % 2 != 0) { odd = num - 1;
	 */
	public static void main(String[] args) {
		int num = TextIO.getlnInt();
		if (num%2==0)
			num = num - 1;
		int total = 0;
		TextIO.putln("Max?");
		for (int i=0;i<=num;i++){
			if (i%2 != 0) {
				if (i==1){
					TextIO.put(i);
				}
				if ((i!=num) && (i!=1)) {
					TextIO.put(" + ");
					TextIO.put(i);
				}
				if (i==num) {
					TextIO.put(" + " + i);
				}
				total = total + i;	
				
			}
		}
		TextIO.putln(" = " + total);
		
		TextIO.put(total + " = ");
		for (int i=num;i>0;i--){
			if (i%2 != 0) {
				if (i==num){
					TextIO.put(i);
				}
				if ((i!=0) && (i!=num)) {
					TextIO.put(" + ");
					TextIO.put(i);
				}
				
			}
		}
		
	} // end of main method
} // end of class
