//UIUC CS125 SPRING 2017 MP. File: GeneAnalysis.java, CS125 Project: Challenge6-RecursionSee, Version: 2017-04-04T10:07:11-0500.143642000
/**
 * @author mapope2
 *
 */
public class GeneAnalysis
{
	/** Wrapper method. Returns the length of the longest 
	 * common subsequence
	 */
	public static int score(String gene1, String gene2)
	{
		char[] g1 = gene1.toCharArray();
		char[] g2 = gene2.toCharArray();
		int length1 = g1.length;
		int length2 = g2.length;
		return score(g1,g2,length1-1, length2-1);
 		// Hint: Use toCharArray() to convert each string to a char array.
		 // call your recursive implementation here with
		// the genes as char arrays, starting at the end of each gene.
	}
	/** Implements longest common subsequence recursive search
	The recursive case is defined as
						S(i-1, j)
	S(i,j) = max {		S(i,j-1)
						S(i-1,j-1)
						S(i-1,j-1) +1 if gene1[i] = gene2[j]

	NB  0<=i < gene1.length
	    0<=j < gene2.length

	You need to figure out the base case.
	* */
	//	define a private recursive Class method 'score' that 
	//	returns an integer the score.
	//	The method should take four parameters- 
	//	two char arrays and two integers (gene1,gene2,i,j)
	//	i and j are the indices into gene1 and gene2 respectively.
	// Use local variables to store a recursive result so that you  do not need to calculate it again.
	// Do not use a loops.
	private static int score(char[] g1, char[] g2, int length1, int length2) {
		if ((length1 < 0) || (length2 < 0))
			return 0;
		int score1 = score(g1,g2,length1-1,length2);
		int score2 = score(g1,g2,length1,length2-1);
		int score3 = score(g1,g2,length1-1,length2-1);
		int score4;
		if (g1[length1] == g2[length2])
			score4 = score(g1,g2,length1-1,length2-1) + 1;
		else
			score4 = 0;
		return Math.max(Math.max(score1,score2), Math.max(score3,score4));
	}

}

