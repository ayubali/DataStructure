package com.data.structure;

public class SortedLinkedList {
	private Node start;

	public SortedLinkedList() {
		start = null;
	}

	public void insert(int value) {
		Node newNode = new Node(value);
		Node curr = start;
		Node prev = null;
		if (start == null) {
			start = newNode;
			return;
		}
		while (curr != null && value > curr.value) {
			prev = curr;
			curr = curr.next;
		}
		if (prev == null) {
			newNode.next = curr;
			start = newNode;
		} else {
			newNode.next = curr;
			prev.next = newNode;

		}
	}

	public Node remove() // return & delete first link
	{
		Node temp = start; // save first
		temp = start.next; // delete first
		return temp; // return value
	}

	public void displayList() {
		System.out.print("List (first-->last): ");
		Node curr = start; // start at beginning of list
		while (curr != null) // until end of list,
		{
			System.out.print(curr.value + "  ");
			curr = curr.next; // move to next link
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		SortedLinkedList theSortedList = new SortedLinkedList();
		theSortedList.insert(20); // insert 2 items
		theSortedList.insert(40);
		theSortedList.displayList(); // display list
		theSortedList.insert(10); // insert 3 more items
		theSortedList.insert(30);
		theSortedList.insert(50);
		theSortedList.displayList(); // display list
	}

}
