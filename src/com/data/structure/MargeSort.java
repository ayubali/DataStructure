package com.data.structure;

public class MargeSort {
	private int[] numbers;
	private int[] helper;
	private int number;

	MargeSort(int[] numbers) {
		this.numbers = numbers.clone();
		this.number = numbers.length;
		this.helper = new int[number];
	}

	public void margeSort(int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			margeSort(low,mid);
			margeSort(mid+1,high);
			marge(low, mid, high);
		}

	}

	public void marge(int low, int mid, int high) {

		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i, j, k;
		i = low;
		j = mid + 1;
		k = low;

		while (i <= mid && j <= high) {
			if (helper[i] < helper[j]) {
				numbers[k++] = helper[i++];
			} else {
				numbers[k++] = helper[j++];
			}
		}

		while (i <= mid) {
			numbers[k++] = helper[i++];
		}
		while (j <= high) {
			numbers[k++] = helper[j++];
		}

	}
	
	public static void main(String[] args) {
        int array[] = {23, 45, 12, 45, 90, 15, 27, 41, 83, 16,5,45,66,7,46,17};
        System.out.println("Original Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println("");
        System.out.println("Sorted Array");

        MargeSort obj = new MargeSort(array);
        obj.margeSort(0,array.length-1);


        for (int i = 0; i < obj.numbers.length; i++) {
            System.out.print("\t" + obj.numbers[i]);
        }

	}
}
