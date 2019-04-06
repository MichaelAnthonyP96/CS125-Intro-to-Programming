//UIUC CS125 SPRING 2017 MP. File: CipherBreaker.java, CS125 Project: Challenge3-TopSecret, Version: 2017-02-14T21:53:35-0600.839381000
/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author mapope2
 */
public class CipherBreaker {

	public static void main(String[] args) {
		TextIO.putln("Text?");
		String line = TextIO.getln();
		String lineUC = line.toUpperCase();
		TextIO.putln(line);
		int spaces = 0;
		int numbers = 0;
		int punctuation1 = 0;
		
		char[] letter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int[] counter = new int[26];
		char[] punctuation = {'"','-','\'','.','!',','};
		
		
		char[] mesg = lineUC.toCharArray();
		for (int i=0;i<mesg.length;i++) {
			if (mesg[i] == ' ')
				spaces++;
			if ((mesg[i] >= '0') && (mesg[i] <= '9'))
				numbers++;
			else {
				for (int a=0;a<letter.length;a++) {
					if (mesg[i] == letter[a]) {
						counter[a]++;
					}
				}		
			}
			
		}
		for (int b=0; b<letter.length;b++) { 
			if (counter[b]>0) {
				TextIO.putln(letter[b] + ":" + counter[b]);
			}
		}
		if (numbers > 0) {
			TextIO.putln("DIGITS:"+numbers);
		}
		if (spaces > 0) {
			TextIO.putln("SPACES:"+spaces);
		}	
		
		for (int c=0; c<mesg.length;c++) {
			for (int p=0;p<punctuation.length;p++) {
				if (mesg[c] == punctuation[p])
					punctuation1++;
			}
		}
		if (punctuation1 > 0) {
			TextIO.putln("PUNCTUATION:"+punctuation1);
		}	
}	}
