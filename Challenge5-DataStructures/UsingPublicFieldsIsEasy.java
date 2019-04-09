//UIUC CS125 SPRING 2017 MP. File: UsingPublicFieldsIsEasy.java, CS125 Project: Challenge5-DataStructures, Version: 2017-03-07T20:15:59-0600.396489000

/**
 * Complete the class method 'analyze' that takes a SimplePublicPair object as an argument
 * and returns a new SimplePublicTriple object.
 * The SimplePublicTriple needs to set up as follows:
 * x = the minimum value of 'a' and 'b'
 * y = the maximum value of 'a' and 'b'
 * description:a*b=M 
 *   where a,b, and M are replaced with the numerical values of a, b and the multiplication of a and b.
 * Your code will create a SimplePublicTriple, initializes the three fields and return a reference to the SimplePublicTriple object.
 *@author mapope2
 */
public class UsingPublicFieldsIsEasy {
	
	public static SimplePublicTriple analyze(SimplePublicPair in) {
		SimplePublicTriple SPT = new SimplePublicTriple();
		SPT.x = 0;
		SPT.y = 0;
		if (in.a > in.b) {
			SPT.x = in.b;
			SPT.y = in.a;
		}
		else {
			SPT.x = in.a;
			SPT.y = in.b;
		}
		SPT.description =  in.a + "*" + in.b + "=" + (in.a*in.b);
		return SPT;
	}
}
