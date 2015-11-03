package com.datastructure;

import java.awt.Font;

public class Queue {

	private int[] queue;
	private final int SIZE;
	private int front;
	private int rear;
	private int count = 0;

	public Queue(int size) {
		this.SIZE = size;
		this.queue = new int[size];
		front = -1;
		rear = -1;
		count = 0;
	}

	public void insert(int value) {
		if (rear == (SIZE - 1)) {
			rear = -1;
		}
		queue[++rear] = value;
		count++;
	}

	public int remove() {
		int num = -1;
		System.out.println("front: " + front + " rear:" + rear);
		if (count > 0) {
			num = queue[++front];
			queue[front] = 0;
			if (front == (SIZE - 1)) {
				front = -1;
			}
			count--;
		}
		return num;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SIZE; i++) {
			sb.append(queue[i] + ", ");
		}
		return sb.toString();

	}
}
