package algorithms.geeksforgeeks.bloomberg;

import java.util.ArrayList;
import java.util.List;

public class NewList {
	public static class Node<T> {
		T val;
		Node next;

		public Node(T t) {
			this.val = t;
		}
	}

	public static void main(String[] args) {
		int n = 97, m = 5;
		Node head = null;
		Node prev = null;
		for (int i = 0; i < n; i++) {
			Node temp = new Node<Integer>(i);
			if (head == null) {
				head = temp;
				prev = temp;
			} else {
				prev.next = temp;
				prev = temp;
			}
		}
		Node newListHead = null;
		Node aux = head;
		int count = 0;
		while (aux != null) {

			if (count == m) {
				Node temp = new Node<>(aux.val);
				if (newListHead == null) {
					newListHead = temp;
					prev = temp;
				} else {
					prev.next = temp;
					prev = temp;
				}
				count = 0;
			}
			count++;
			aux = aux.next;
		}

		while (newListHead != null) {
			System.out.println(newListHead.val);
			newListHead = newListHead.next;
		}
	}
}
