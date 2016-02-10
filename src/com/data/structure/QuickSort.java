package com.data.structure;

public class QuickSort {

	public static int partition(int arr[], int left, int right) {
		int i = left;
		int j = right;
		int pivot = arr[left ];
		while (i <= j) {
            while (arr[i] < pivot) 
                i++; 
          while (arr[j] > pivot) 
                j--; 
          if (i <= j) { 
               int tmp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = tmp; 
                i++; 
                j--; 
          } 


		}
		return i;
	}

	public static void quickSort(int arr[], int left, int right) {
		
		if(right-left <= 0) // if size <= 1,
			return;
		int index = partition(arr, left, right);
		if (left < index - 1) {
			quickSort(arr, left, index - 1);
		}
		if (index < right) {
			quickSort(arr, index+1, right);
		}

	}

	public static void main(String[] args) {
		int array[] = { 23, 45, 12, 45, 90, 15, 27, 41, 83, 16, 5, 45, 66, 7,
				46, 17 };
		System.out.println("Original Array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print("\t" + array[i]);
		}
		System.out.println("");
		System.out.println("Sorted Array");
		quickSort(array, 0, array.length - 1);

		for (int i = 0; i < array.length; i++) {
			System.out.print("\t" + array[i]);
		}

	}
	//https://www.youtube.com/watch?v=8hHWpuAPBHo

}
