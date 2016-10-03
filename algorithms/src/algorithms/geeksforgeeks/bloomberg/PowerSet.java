package algorithms.geeksforgeeks.bloomberg;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {
	public static void main(String[] args) {
		int[] numbers = new int[] { 0, 1, 3, 4 };
		int count = 1 << numbers.length;
		Set<Set<Integer>> result = new HashSet<>();
		for (int i = 0; i < count; i++) {
			int k = i;
			int count1 = 0;
			Set<Integer> temp = new HashSet<>();
			while (k > 0) {
				if (k % 2 == 1)
					temp.add(numbers[count1]);
				k = k / 2;
				count1++;
			}
			result.add(temp);
		}

		System.out.println(result);
	}
}
