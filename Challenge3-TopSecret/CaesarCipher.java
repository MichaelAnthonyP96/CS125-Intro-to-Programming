//UIUC CS125 SPRING 2017 MP. File: CaesarCipher.java, CS125 Project: Challenge3-TopSecret, Version: 2017-02-14T21:53:35-0600.839381000
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author mapope2
 */
public class CaesarCipher {

	public static void main(String[] strings) {
		//TODO: Delete the following line and write your implementation here- 
		TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
		boolean position = false;
		boolean position1 = false;
		int offset = TextIO.getlnInt();
		
		while ((offset < -25) || (offset == 0) || (offset > 25))
		{
			if (offset == 999) {
				position = true;
				break;
			}
			if (offset == -999) {
				position1 = true;
				break;
			}
			TextIO.putln(offset + " is not a valid shift value.");
			TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
			offset = TextIO.getlnInt();
		}
		
		if ((position) || (position1)){
			TextIO.putln("Using position shift");
		}
		else
		TextIO.putln("Using shift value of " + offset);
		
		boolean keep_going = true;
		while(keep_going) {
			TextIO.putln("Please enter the source text (empty line to quit)");
			String source = TextIO.getln();
			boolean empty = false;
			if (source.equals("")) {
				TextIO.putln("Bye.");
				keep_going = false; 
				empty = true;
			}	
			if (!empty){
				String sourceUC = source.toUpperCase();
				TextIO.putln("Source   :" + source);
				char[] mesg = sourceUC.toCharArray();
				TextIO.put("Processed:");
				for (int i=0;i<mesg.length;i++) {
					int new_offset = position ? i : offset; 
					new_offset = position1 ? (-i +260) : new_offset;
					if ((mesg[i] >= 'A') && (mesg[i] <= 'Z'))
						TextIO.put((char)('A' + (mesg[i] - 'A' + new_offset + 26 )%26));
					else TextIO.put(mesg[i]);
			}
			TextIO.putln();
		}
		}
	}

}
