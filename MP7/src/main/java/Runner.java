package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
	/**
	 * Main program that offers options and interacts with the users.
	 * 
	 * @param args - empty array.
	 */
	public static void main(final String[] args) {
		boolean isRunning = true; // keeps the program running until user wants to stop.
		Scanner s = new Scanner(System.in);
		while (isRunning) {
			System.out.println("Welcome to Sorting Machine. What would you like to do?");
			System.out.println("Sort an Array");
			System.out.println("Compare runtimes");
			System.out.println("Stop");
			String actionInput = s.nextLine(); // take input of the action wanted.
			boolean isValid = false;
			while (!isValid) { // check whether a valid option was picked or not
				if (actionInput.equalsIgnoreCase("Sort an Array")) {
					isValid = true;
				} else if (actionInput.equalsIgnoreCase("Compare runtimes")) {
					isValid = true;
				} else if (actionInput.equalsIgnoreCase("Stop")) {
					isRunning = false;
					System.out.println("Thank you for using Sorting Machine!");
					break;
				} else {
					System.out.println("Please input one of the options specified.");
					actionInput = s.nextLine();
				}
			}
			if (actionInput.equalsIgnoreCase("Sort an Array")) { // take action on sort option
				int arrLen = 0;
				while (true) {
					try {
						System.out.println("Please enter an array size");
						arrLen = s.nextInt(); // make sure to check for input mismatch exception
						break;
					} catch (InputMismatchException ex) {
						System.out.println("invalid input, please try again");
						s.next();
						continue;
					}
				}
				int[] unsortedArr = createArr(arrLen);
				System.out.println("Choose a sorting algorithm - "); // have user choose what kind of sort?
				System.out.println("Quick sort -" + "\n"
						+ "Time Complexity: Best Case: O(nlg n), Average Case: O(nlg n), Worst Case: O(n^2)");
				System.out.println("Merge Sort -" + "\n"
						+ "Time Complexity: Best Case: O(nlg n), Average Case: O(nlg n), Worst Case: O(nlg n)");
				System.out.println("Insertion Sort -" + "\n"
						+ "Time Complexity: Best Case: O(n), Average: O(n^2), Worst Case: O(n^2)");
				System.out.println("Bubble Sort -" + "\n"
						+ "Time Complexity: Best Case: O(n), Average: O(n^2), Worst Case: O(n^2)");
				boolean sortIsValid = false;
				String sortInput = s.nextLine();
				while (!sortIsValid) { // loop through to check whether option chosen is valid
					if (sortInput.equalsIgnoreCase("Quick Sort")) {
						sortIsValid = true;
					} else if (sortInput.equalsIgnoreCase("Merge Sort")) {
						sortIsValid = true;
					} else if (sortInput.equalsIgnoreCase("Insertion Sort")) {
						sortIsValid = true;
					} else if (sortInput.equalsIgnoreCase("Bubble Sort")) {
						sortIsValid = true;
					} else {
						System.out.println("Please choose one of the following sorting algorithms.");
						sortInput = s.nextLine();
					}
				}
				if (sortInput.equalsIgnoreCase("Quick Sort")) {
					quickSortTest(unsortedArr);
				} else if (sortInput.equalsIgnoreCase("Merge Sort")) {
					mergeSortTest(unsortedArr);
				} else if (sortInput.equalsIgnoreCase("Insertion Sort")) {
					insertSortTest(unsortedArr);
				} else if (sortInput.equalsIgnoreCase("Bubble Sort")) {
					bubbleSortTest(unsortedArr);
				}
			} else if (actionInput.equalsIgnoreCase("Compare runtimes")) {
				int arrLen = 0;
				while (true) {  //ask for an array size
					try {
						System.out.println("Please enter an array size");
						arrLen = s.nextInt(); // make sure to check for input mismatch exception
						break;
					} catch (InputMismatchException ex) {
						System.out.println("invalid input, please try again");
						s.next();
						continue;
					}
				}
				int[] unsortedArr = createArr(arrLen);   //use this array to compare the four algorithms
				int[] bubbleArr = unsortedArr.clone();
				int[] insertArr = unsortedArr.clone();
				int[] mergeArr = unsortedArr.clone();
				int[] quickArr = unsortedArr.clone();
				System.out.println("Testing quick sort");  //run quicksort
				long quickTime = quickSortTest(quickArr);
				System.out.println("Testing bubble sort");  //run bubble sort
				long bubbleTime = bubbleSortTest(bubbleArr);
				System.out.println("Testing insert sort");   //run insert sort
				long insertTime = insertSortTest(insertArr);
				System.out.println("Testing merge sort");   //run merge sort
				long mergeTime = mergeSortTest(mergeArr);    //display run times
				System.out.println("Quick sort run time: " + quickTime + " ms");
				System.out.println("Bubble sort run time: " + bubbleTime + " ms");
				System.out.println("Insert sort run time: " + insertTime + " ms");
				System.out.println("Merge sort run time: " + mergeTime + " ms");
				System.out.println("");
				System.out.println("");
			}
		}
		if (!isRunning) {   //close scanner once finished
			s.close();
		}
	}

	/**
	 * Creates the array of given size with random numbers ranging
	 * from 1 to 100.
	 * 
	 * @param len - length of desired array.
	 * @return new array of desired length and randomized elements.
	 */
	public static int[] createArr(final int len) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 100 + 1);
		}
		return arr;
	}

	/**
	 * Quicksort method which sorts the array, shows steps
	 * and keeps track runtime by millisecond.
	 * 
	 * @param arr - initial unsorted array.
	 * @return - runtime of sorting algorithm.
	 */
	public static long quickSortTest(final int[] arr) {
		// start calculating runtime:
		long start = System.currentTimeMillis();
		int n = arr.length;
		Quicksort ob = new Quicksort();
		System.out.println("Given Array: ");
		Quicksort.printArr(arr);
		ob.quicksort(arr, 0, n - 1);
		System.out.println("\nSorted array");
		Quicksort.printArr(arr);
		long end = System.currentTimeMillis();
		System.out.println("Total runtime of program: " + (end - start) + "ms" +"\n");
		return end - start;
	}

	/**
	 * Bubblesort method which sorts the array, shows steps
	 * and keeps track runtime by millisecond.
	 * 
	 * @param arr - initial unsorted array.
	 * @return - runtime of sorting algorithm.
	 */
	public static long bubbleSortTest(final int[] arr) {
		long start = System.currentTimeMillis();
		Bubblesort ob = new Bubblesort();
		System.out.println("Given Array: ");
		Bubblesort.printArray(arr);
		ob.bubbleSort(arr);
		System.out.println("\nSorted array");
		Bubblesort.printArray(arr);
		long end = System.currentTimeMillis();
		System.out.println("Total runtime of program: " + (end - start) + "ms" + "\n");
		return end - start;
	}

	/**
	 * Insertion sort method that sorts the array, shows steps
	 * and keeps track of the runtime.
	 * 
	 * @param arr - intial unsorted array
	 * @return runtime of sorting algorithm.
	 */
	public static long insertSortTest(final int[] arr) {
		long start = System.currentTimeMillis();
		Insertsort ob = new Insertsort();
		System.out.println("Given Array: ");
		Insertsort.printArray(arr);
		ob.sort(arr);
		System.out.println("\nSorted array");
		Insertsort.printArray(arr);
		long end = System.currentTimeMillis();
		System.out.println("Total runtime of program: " + (end - start) + "ms" + "\n");
		return end - start;
	}

	/**
	 * Merge sort method to sort the array, show the steps,
	 * and to keep track of the runtime.
	 * 
	 * @param arr - initial unsorted array.
	 * @return runtime of sorting algorithm.
	 */
	public static long mergeSortTest(final int[] arr) {
		long start = System.currentTimeMillis();
		System.out.println("Given Array: ");
		Mergesort.printArr(arr);
		Mergesort ob = new Mergesort();
		ob.sort(arr, 0, arr.length - 1);
		System.out.println("\nSorted array");
		Mergesort.printArr(arr);
		long end = System.currentTimeMillis();
		System.out.println("Total runtime of program: " + (end - start) + "ms" + "\n");
		return end - start;
	}
}