package main.java;

public class Mergesort {
	/**
	 * mergesort main method.
	 *
	 * @param data - data array we are sorting
	 * @param lo - low boundary
	 * @param hi - high boundary
	 */
	public void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int left[] = new int[n1];
		int right[] = new int[n2];
		System.out.println("Split original array into left and right array" +
		" with size " + n1 + " and " + n2 + " respectively.");
		for (int i = 0; i < n1; ++i) {
			left[i] = arr[l + i];
		}
		System.out.print("Left array: ");
		printArr(left);
		for (int j = 0; j < n2; ++j) {
			right[j] = arr[m + 1 + j];
		}
		System.out.print("Right array: ");
		printArr(right);
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
		System.out.print("Merge back the left and right array: ");
		printArr(arr);
		System.out.println("");
	}

	public void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	/**
	 * print data array we are currently sorting
	 * 
	 * @param data
	 */
	public static void printArr(final int[] data) { // array format.
		System.out.print("[");
		for (int i = 0; i < data.length; i++) {
			if (i != data.length - 1) {
				System.out.print(data[i] + ", ");
			} else {
				System.out.print(data[i]);
			}
		}
		System.out.print("]");
		System.out.println("");
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int arr[] = { 10, 7, 8, 9, 1, 5, 6, 4, 6, 8, 10, 5, 7, 3, 2, 6, 3};
		System.out.println("Given Array");
		printArr(arr);
		Mergesort ob = new Mergesort();
		ob.sort(arr, 0, arr.length - 1);
		System.out.println("\nSorted array");
		printArr(arr);
		long end = System.currentTimeMillis();
		System.out.println("Total runtime of program: " + (end - start) + "ms");

	}
}
