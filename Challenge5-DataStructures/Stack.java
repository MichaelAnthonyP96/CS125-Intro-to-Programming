//UIUC CS125 SPRING 2017 MP. File: Stack.java, CS125 Project: Challenge5-DataStructures, Version: 2017-03-07T20:15:59-0600.396489000
//@author mapope2

public class Stack {
	/** Adds a value to the top of the stack.*/
	private String[] Stack = new String[0];
	
	public void push(String value){
		String[] newStack = new String[Stack.length + 1];
		newStack[0] = value;
		for (int i=0;i < Stack.length; i++)
			newStack[i+1] = Stack[i];
		Stack = newStack;
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		String returnValue = null;
		if (Stack.length != 0) {
			String[] newStack = new String[Stack.length - 1];
			returnValue = Stack[0];
			for (int i=1;i<Stack.length;i++)
				newStack[i-1] = Stack[i];
			Stack = newStack;
			return returnValue;
		}
		else
			return returnValue;
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek() {
		if (Stack.length != 0)
			return Stack[0]; 
		else 
			return null;
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		if (Stack.length == 0)
			return true;
		else
			return false;
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return Stack.length;
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString() {
		String returnValue = "";
		if (Stack.length !=0) {
			for (int i=Stack.length -1;i>=0;i--) {
				returnValue = returnValue + Stack[i] + "\n";
			}
		}	
		return returnValue;
	}
}
