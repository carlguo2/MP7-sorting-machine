package main.java;

public class Bubblesort {
	/**
	 * Actual bubble sort algorithm.
	 * 
	 * @param arr - unsorted array we are trying to sort.
	 */
	public void bubbleSort(final int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					System.out.println("Swap array elements at index " + j + " and " + (j+1));
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					printArray(arr);
					System.out.println("");
				}
	}

	/**
	 * Method to print out the array values.
	 * 
	 * @param arr - array we are trying to print out.
	 */
	public static void printArray(final int arr[]) {
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
	 * Main method used as a tester for the sorting algorithm.
	 * 
	 * @param args - empty array.
	 */
	public static void main(final String args[]) {
		long start = System.currentTimeMillis();
		int arr[] = { 10, 7, 8, 9, 1, 5, 6, 4, 6, 8, 10, 5, 7, 3, 2, 6, 3};
		Bubblesort ob = new Bubblesort();
		ob.bubbleSort(arr);
		printArray(arr);
		long end = System.currentTimeMillis();
		System.out.println("Total runtime of program: " + (end - start) + "ms");
	}
}
