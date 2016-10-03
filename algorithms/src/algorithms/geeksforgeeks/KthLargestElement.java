package algorithms.geeksforgeeks;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
	PriorityQueue<Integer> aux = null;
	int capacity = 0;

	public KthLargestElement(int capacity) {
		aux = new PriorityQueue(capacity);
		this.capacity = capacity;
	}

	public void add(int n) {
		if (aux.size() < this.capacity) {
			aux.add(n);
		} else {
			if (aux.peek() < n) {
				aux.remove();
				aux.add(n);
			}
		}
	}

	public Integer getValue() {
		if (aux.size() == this.capacity) {
			return aux.peek();
		} else {
			return null;
		}
	}

	public static void main(String[] args) {

		KthLargestElement elem = new KthLargestElement(3);
		elem.add(23);
		elem.add(10);
		elem.add(15);
	//	elem.add(70);
		System.out.println(elem.getValue());
	}
}
