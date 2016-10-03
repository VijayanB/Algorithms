package algorithms.geeksforgeeks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetMin {
	Queue<Integer> first = new LinkedList<>();

	Deque<Integer> aux = new LinkedList<>();

	public GetMin() {
		add(5);
		add(10);
		add(7);
		add(11);
		add(19);
	}

	public void add(Integer inp) {
		first.add(inp);
		while (!aux.isEmpty() && aux.peekLast() > inp) {
			aux.removeLast();
		}
		aux.addLast(inp);
		System.out.println("q1" + first);
		System.out.println("q2" + aux);
	}

	public boolean isEmpty() {
		return first.isEmpty();
	}

	public Integer remove() {
		if (first.isEmpty()) {
			return null;
		}
		int inp = first.remove();
		if (inp == aux.peekFirst()) {
			return aux.removeFirst();
		}
		return null;
	}

	public Integer getMin() {
		return aux.peekFirst();
	}

	public static void main(String[] args) {
		GetMin obj = new GetMin();

		while (!obj.isEmpty()) {
			System.out.println(obj.getMin());
			obj.remove();

		}

	}
}
