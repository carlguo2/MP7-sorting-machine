package main.java;

public class Quicksort {
	/**
	 * This uses median of three method to find a good pivot for array.
	 * 
	 * @param arr - array we are using
	 * @param lo - low index we are interested in.
	 * @param hi - high index we are interested in.
	 * @return median value calculated.
	 */
	public int medianOfThree(final int[] arr, final int lo, final int hi) {
		int mid = (lo + hi) / 2;
		if (arr[lo] > arr[mid] && arr[lo] < arr[hi] || arr[lo] < arr[mid] && arr[lo] > arr[hi]) {
			return lo;
		} else if (arr[mid] > arr[lo] && arr[mid] < arr[hi] || arr[mid] < arr[lo] && arr[mid] > arr[hi]) {
			return mid;
		} else {
			return hi;
		}
	}

	/**
	 * Helper function to print out array to display.
	 * 
	 * @param arr - array we are sorting.
	 */
	public static void printArr(final int[] arr) { // array format.
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				System.out.print(arr[i] + ", ");
			} else {
				System.out.print(arr[i]);
			}
		}
		System.out.print("]");
		System.out.println("");
	}

	/**
	 * Actual method that does the quick sort algorithm.
	 * Combines partition and partitionWrapper method.
	 * 
	 * @param arr - array that needs to be sorted
	 * @param lo - low boundary of array to be sorted.
	 * @param hi - upper boundary of array to be sorted.
	 */
	public void quicksort(final int[] arr, final int lo, final int hi) {
		if (hi > lo + 1) { // size is 3 or more
			int m = partitionWrapper(arr, lo, hi);
			quicksort(arr, lo, m - 1);
			quicksort(arr, m + 1, hi);
		} else if ((hi == lo + 1) && (arr[lo] > arr[hi])) { // size is 0, 1, or 2 do a swap
			int temp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = temp;
			printArr(arr);
		}
	}

	/**
	 * This method uses partition method to move pivot into correct location
	 * and move elements around.
	 * 
	 * @param arr - array we are sorting.
	 * @param lo - low boundary of array.
	 * @param hi - upper boundary of array.
	 * @return index where pivot is currently stored.
	 */
	public int partitionWrapper(final int[] arr, final int lo, final int hi) {
		// swap low index and median of three index
		int med = medianOfThree(arr, lo, hi);
		System.out.println("By median of three, pivot is: " + arr[med] +
				" index at " + med);
		System.out.println("Swap low index " + lo +  " and median " + med);
		int temp1 = arr[lo];
		arr[lo] = arr[med];
		arr[med] = temp1;
		printArr(arr);
		int m = partition(arr, lo + 1, hi, arr[lo]);
		System.out.println("Swap low index " + lo + " and hi index " + hi + ":");
		int temp2 = arr[lo];
		arr[lo] = arr[m];
		arr[m] = temp2;
		printArr(arr);
		System.out.println("");
		return m;
	}

	/**
	 * Method used to recursively partition the array with selected pivot.
	 * 
	 * @param arr - array to be sorted.
	 * @param lo - low boundary of array.
	 * @param hi - upper boundary of array.
	 * @param pivot - pivot used to partition array in quick sort.
	 * @return returns index partition should be at.
	 */
	public int partition(final int[] arr, final int lo, final int hi, final int pivot) {
		System.out.println("Partition from lo index: " + lo + " to hi index: " + hi);
		if (hi == lo) {
			if (arr[lo] < pivot) {
				return lo;
			}
			else {
				return lo - 1;
			}
		} else if (arr[lo] <= pivot) {
			return partition(arr, lo + 1, hi, pivot);
		} else {
			System.out.println("swap arrays at index " + lo + " and index "+ hi);
			int temp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = temp;
			printArr(arr);
			return partition(arr, lo, hi - 1, pivot);
		}
	}

	/**
	 * Main method to use as a tester for quicksort.
	 * @param args - empty array.
	 */
	public static void main(final String[] args) { // useful as a tester
		// start calculating runtime:
		long start = System.currentTimeMillis();
		int arr[] = { 10, 7, 8, 9, 1, 5, 6, 4, 6, 8, 10, 5, 7, 3, 2, 6, 3};
		int n = arr.length;
		Quicksort ob = new Quicksort();
		ob.quicksort(arr, 0, n - 1);
		System.out.println("Final array: ");
		Quicksort.printArr(arr);
		long end = System.currentTimeMillis();
		System.out.println("Total runtime of program: " + (end - start) + "ms");
	}
}