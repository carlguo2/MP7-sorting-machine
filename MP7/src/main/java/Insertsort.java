package main.java;

public class Insertsort {
		public void sort(int arr[])
		{
	    	int n = arr.length;
	    	for (int i = 1; i < n; ++i)
	    	{
	        	int key = arr[i];
	        	System.out.println("Pick key to be " + key);
	        	int j = i-1;
	        	while (j>=0 && arr[j] > key)
	        	{
	        		System.out.println("Compare if " + key + " is smaller than " + 
	        				arr[j] + " . If so, then insert " + key + " into index " + j);
	            	arr[j + 1] = arr[j];
	            	j = j - 1;
	        	}
	        	arr[j + 1] = key;
	        	System.out.println(key + " finally inserted at index " + (j+1));
	        	printArray(arr);
            	System.out.println("");
	    	}
		}
		public static void printArray(int arr[]) {
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
		public static void main(String args[]) {   	 
	   	 	long start = System.currentTimeMillis();
	    	int arr[] = {12, 11, 13, 5, 6};
	    	Insertsort ob = new Insertsort();   	 
	    	ob.sort(arr);
	    	printArray(arr);
	    	long end = System.currentTimeMillis();
	    	System.out.println("Total runtime of program: " + (end - start) + "ms");
		}
}
