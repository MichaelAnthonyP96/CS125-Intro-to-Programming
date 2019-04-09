//UIUC CS125 SPRING 2017 MP. File: LinkedList.java, CS125 Project: Challenge6-RecursionSee, Version: 2017-04-04T10:07:11-0500.143642000
/**
 * @author mapope2
 *
 */
public class LinkedList {
	// Get and Set methods are NOT necessary!

	private LinkedList next; 	
	private final String word;

	/** Constructs this link.
	 * @param word ; a single word (never null).
	 * @param next ; the next item in the chain (null, if there are no more items).
	 */
	public LinkedList(String word, LinkedList next) {
		this.word = word;
		this.next = next;
	}

	/**
	 * Converts the entire linked list into a string representation.
	 */
	public String toString() {
		if (next == null)
			return word;// BASE CASE; no more recursion required

		// Recursive case:
		String restOfString = next.toString(); // Forward Recursion
		return word + ";" + restOfString;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int getCount() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.getCount(); // Forward recursion
	}
	
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param word
	 */
	public void append(String word) {
		if (next==null)
			next = new LinkedList(word, null);
		else 
			next.append(word);

	}
	/**
	 * Recursively counts the total number of letters used.
	 * 
	 * @return total number of letters in the words of the linked list
	 */
	public int getLetterCount() {
		int total = 0;
		if (next==null)
			return word.length();
		else {
			total = word.length() + next.getLetterCount();
			return total;
		}
		// returns the total number of letters. word1.length() +
		// word2.length()+...
		// "A" -> "CAT" -> null returns 1 + 3 = 4.
	}

	/**
	 * Recursively searches for and the returns the longest word.
	 * @return the longest word i.e. word.length() is maximal.
	 */
	public String getLongestWord() {
		// recursive searches for the longest word
		if (next==null) {
			return word;
		}
		else if (next.getLongestWord().length() > word.length())
			return next.getLongestWord();
		else return word;
			
	}

	/** Converts linked list into a sentence (a single string representation).
	* Each word pair is separated by a space.
	* A period (".") is appended after the last word.
	* The last link represents the last word in the sentence.*/
	public String getSentence() {
		if (next == null)
			return word + ".";
		else 
			return word + " " + next.getSentence();
	}
	
	/**
	 * Converts linked list into a sentence (a single string representation).
	 * Each word pair is separated by a space. A period (".") is appended after
	 * the last word. The last link represents the first word in the sentence
	 * (and vice versa). The partialResult is the partial string constructed
	 * from earlier links. This partialResult is initially an empty string. 
	 */
	public String getReversedSentence(String partialResult) {
		String s = word + " ";
		s += partialResult;
		if (next == null) {
			s = s.trim();
			s += ".";
			return s;
		}
		return next.getReversedSentence(s);
	}
	

	/** Creates a linked list of words from an array of strings.
	 * Each string in the array is a word. */
	public static LinkedList createLinkedList(String[] words) {
		return new LinkedList (words[0], create(words,1));
		// Hint: This is a wrapper method. You'll need to create your
		// own recursive method.
		// Yes this is possible _without_ loops!
	}
	public static LinkedList create(String[] words, int i) {
		if (i>=words.length -1)
			return new LinkedList(words[words.length-1], null);
		return new LinkedList(words[i], create(words, i+1));
		
	}

	/**
	 * Searches for the following word in the linked list. Hint: use .equals not ==
	 * to compare strings.
	 * 
	 * @param word
	 * @return true if the linked list contains the word (case sensivitive)
	 */
	public boolean contains(String word) {
		if (next==null){
			if (this.word.equals(word))
				return true;
			else 
				return false;
		} 
		return next.contains(word);
	}

	/** Recursively searches for the given word in the linked list.
	 * If this link matches the given word then return this link.
	 * Otherwise search the next link.
	 * If no matching links are found return null.
	 * @param word the word to search for.
	 * @return The link that contains the search word.
	 */
	public LinkedList find(String word) {
		if (next == null) {
			if (word.equals(this.word))
				return this;
			else
				return null;
		}
		else {
			if (word.equals(this.word))
				return this;
			return next.find(word);
		}

	}

	/**
	 * Returns the last most link that has the given word, or returns null if
	 * the word cannot be found.
	 * Hint: Would forward recursion be useful?
	 * @param word the word to search for.
	 * @return the last LinkedList object that represents the given word, or null if it is not found.
	 */
	public LinkedList findLast(String word) {
		if (next==null) {
			if (word.equals(this.word))
				return this;
			else
				return null;
		}
		if (word.equals(this.word)) {
			if (next.findLast(word) == null)
				return this;
		}
		return next.findLast(word);
			
		}
	

	public LinkedList insert(String string) {
		if (string.compareTo(this.word) < 0) {
			return new LinkedList(string,this);
		}
		if (next==null) 
			next = new LinkedList(string,null);
		else
			next.insert(string);
		return this;
		
	}

}
