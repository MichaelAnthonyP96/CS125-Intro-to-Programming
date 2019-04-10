//UIUC CS125 SPRING 2017 MP. File: MolecularSort.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2017-04-11T09:33:02-0500.466225000
//@author mapope2
public class MolecularSort {

	/** Sorts each xyz coordinate using it's Z value (coord[i][2] <= coord[j][2] for i<j). */
	static void sortCoordsByZ(double[][] coords) {
		recursiveSort(coords,0,coords.length-1);
	}

	/**
	 * recursively sorts coordinates entries by their z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static void recursiveSort(double[][] coords, int lo, int hi) {
		if (lo>=hi)
			return;
		swap(coords,lo,findIndexOfZMinimum(coords,lo,hi));
		recursiveSort(coords,lo+1,hi);
	}

	/**
	 * returns the index of the entry with the lowest Z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static int findIndexOfZMinimum(double[][] coords, int lo, int hi) {
		if (lo == hi)
			return hi;
		int min = findIndexOfZMinimum(coords,lo+1,hi); 
		if(coords[min][2]<coords[lo][2]) 
			return min; 
		return lo;
	}
	

	/* Swaps the (x,y and z) values of the i-th and j-th coordinates.*/
	static void swap(double[][] coords, int i, int j) {
		double tempx = coords[i][0];
		double tempy = coords[i][1];
		double tempz = coords[i][2];
		coords[i][0] = coords[j][0];
		coords[i][1] = coords[j][1];
		coords[i][2] = coords[j][2];
		coords[j][0] = tempx;
		coords[j][1] = tempy;
		coords[j][2] = tempz;
	}
}
