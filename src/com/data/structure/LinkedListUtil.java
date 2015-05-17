package com.data.structure;

public class LinkedListUtil {

	public static boolean hasLoop(Node start) {
		if (start == null) {
			return false;
		}
		Node slow, first;
		slow = first = null;
		while (true) {
			slow = slow.next;
			if (first.next != null) {
				first = first.next.next;
			} else {
				return false;
			}
			if (first == null || slow == null) {
				return false;
			}
			if (slow == first) {
				return true;
			}

		}
	}

	public static Node LastSecondNode(Node start) {
		Node end = start;
		Node second = start;
		if (end.next != null) {
			end = end.next.next;
		}
		while (end != null) {
			end = end.next;
			second = second.next;
		}
		return second;
	}

	public static void ReverseList(Node start) {
		Node curr = start;
		Node prev = null;
		Node next = null;
		if (start == null || start.next == null) {
			return;
		}
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		start = prev;

	}

}
