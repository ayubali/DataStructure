package com.data.structure;

public class QuickSortGeneric {

	private static <T extends Comparable<T>> int split(T[] list, int low,
			int high) {

		int left = low + 1;
		int right = high;
		T pivot = list[low];
		while (true) {

			while (list[left].compareTo(pivot) < 0) {
				left++;
			}
			while (list[right].compareTo(pivot) > 0) {
				right--;
			}

			if (left >= right) {
				break;
			}
			// swap let and right
			T temp = list[left];
			list[left] = list[right];
			list[right] = temp;
			left++;
			right--;
		}

		// swap pivot with left-1 position
		list[low] = list[left - 1];
		list[left - 1] = pivot;

		return left-1;
	}

	private static <T extends Comparable<T>> void sort(T[] list, int low,
			int high) {
		if (high - low <= 0) {
			return;
		}

		int splitPoint = split(list, low, high);
		sort(list, low, splitPoint - 1);
		sort(list, splitPoint + 1, high);
	}

	public static <T extends Comparable<T>> void sort(T[] list) {
		if (list.length <= 1) {
			return;
		}
		sort(list, 0, list.length - 1);
	}

	public static void main(String[] args) {
		Integer array[] = { 23, 4, 12, 45, 90};
		sort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i].intValue() + " ,");
		}
	}
}
