package com.data.structure;

public class QuickSort {

	public static int partition(int list[], int low, int high) {
		int left = low + 1;
		int right = high;
		int pivot = list[low];
		while (true) {
			while (list[left] < pivot)
				left++;
			while (list[right] > pivot)
				right--;

			if (left >= right) {
				break;
			}
			int tmp = list[left];
			list[left] = list[right];
			list[right] = tmp;
			left++;
			right--;
		}

		// swap the privot
		list[low] = list[left - 1];
		list[left - 1] = pivot;

		return left - 1;
	}

	public static void quickSort(int arr[], int left, int right) {

		if (right - left <= 0) // if size <= 1,
			return;
		int index = partition(arr, left, right);
		quickSort(arr, left, index - 1);
		quickSort(arr, index + 1, right);
	}

	public static void main(String[] args) {
		int array[] = { 23, 4, 12, 45, 90};
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
	// https://www.youtube.com/watch?v=8hHWpuAPBHo

}
