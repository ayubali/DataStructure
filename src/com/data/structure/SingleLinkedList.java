package com.data.structure;

class Node {
	int value;

	public Node(int value) {
		this.value = value;
	}

	Node next;

	@Override
	public String toString() {
		return "Node [value=" + value + ", next=" + next + "]";
	}
}

interface ILinkedable {

	public void insertFirst(int value);

	public Node deleteFirst();

	public Node delete(int value);

	public Node find(int value);

	public void displayList();

	public boolean isEmpty();

}

public class SingleLinkedList implements ILinkedable {

	public Node start;

	public SingleLinkedList() {
		this.start = null;
	}

	@Override
	public void insertFirst(int value) {
		Node newNode = new Node(value);
		if (start != null) {
			newNode.next = start;
			start = newNode;
		} else {
			start = newNode;
		}

	}

	@Override
	public Node deleteFirst() {
		Node node = null;
		if (start != null) {
			node = start;
			start = start.next;
		}
		return node;

	}

	@Override
	public boolean isEmpty() {
		if (start != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void displayList() {
		System.out.println("Start-->Last:  ");
		Node curr = start;
		while (curr != null) {
			System.out.print(curr + " --> ");
			curr = curr.next;
		}

	}

	@Override
	public Node delete(int value) {

		Node curr = start;
		Node prev = start;
		while (curr != null) {
			if (curr.value == value) {
				break;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		if (curr == null) {
			return null;
		}

		// update pointer
		if (curr == start) {
			start = start.next;
		} else {
			prev.next = curr.next;
		}
		return curr;
	}

	@Override
	public Node find(int value) {

		Node curr = start;
		while (curr != null) {
			if (curr.value == value) {
				break;
			} else {
				curr = curr.next;
			}

		}

		return curr;
	}

	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.insertFirst(22);
		linkedList.insertFirst(44);
		linkedList.insertFirst(65);
		linkedList.insertFirst(45);
		linkedList.insertFirst(45);
		linkedList.insertFirst(34);
		System.out.println(linkedList.start);

	}
}
