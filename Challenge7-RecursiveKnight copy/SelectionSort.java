//UIUC CS125 SPRING 2017 MP. File: SelectionSort.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2017-04-11T09:33:02-0500.466225000
//@author mapope2
public class SelectionSort {
	/**
	 * Sorts the entire array using selection sort
	 * This is just a wrapper method that calls the 
	 * recursive method with the correct parameter lo,hi values.
	 * @param data
	 */
	public static void sort(double[] data) {
		sort(data,0,data.length-1);
	}

	/** Recursively sorts the sub array lo...hi using selection sort algorithm.*/
	public static void sort(double[] data, int lo, int hi) {
		if (lo>=hi)
			return;
		swap(data,lo,findMin(data,lo,hi));
		sort(data,lo+1,hi);
	}

	/** Helper method for selection sort: Swaps values at indices i and j*/
	public static void swap(double[] data, int i, int j) {
		double temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	/**
	 * Recursively finds the position of the smallest value of the values lo...hi (inclusive). 
	 * @param data
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int findMin(double[] data, int lo, int hi) {
		if (lo==hi)
			return lo;
		int min = findMin(data,lo+1,hi); 
		if(data[min]<data[lo]) 
			return min; 
		return lo; 

	}

}
