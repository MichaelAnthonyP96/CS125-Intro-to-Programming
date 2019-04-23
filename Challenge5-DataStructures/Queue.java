//UIUC CS125 SPRING 2017 MP. File: Queue.java, CS125 Project: Challenge5-DataStructures, Version: 2017-03-07T20:15:59-0600.396489000

public class Queue {
	/** Adds the value to the front of the queue.
	 * @author mapope2
	 * Note the queue automatically resizes as more items are added. */
	private double[] Queue = new double[0];
	
	public void add(double value) {
		double[] newQueue = new double[Queue.length + 1];
		newQueue[0] = value;
		for (int i=1;i<newQueue.length;i++) {
			newQueue[i]=Queue[i-1];
		}
		Queue = newQueue;
	}
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if (Queue.length == 0) {
			return 0;
		}
		else {
			double returnValue = Queue[Queue.length-1];
			double[] newQueue = new double[Queue.length - 1];
			for (int i=0;i<newQueue.length;i++) {
				newQueue[i]=Queue[i];	
			}
			Queue = newQueue;
			return returnValue;

		}
	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		return Queue.length;		
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		if (Queue.length == 0)
			return true;
		else 
			return false;
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		String returnValue = "";
		for (int i=Queue.length-1;i>=0;i--) {
			returnValue = returnValue + Queue[i];
			if (i>0)
				returnValue = returnValue + ",";
		}
		return returnValue;
	}
}
