package algorithms.geeksforgeeks.bloomberg;

public class MaximumProduct {
	public static void main(String[] args) {
		int[] numbers = new int[] { -4, -3, -2 };
		int[] maxEnd = new int[numbers.length];
		int[] minEnd = new int[numbers.length];
		maxEnd[0] = numbers[0];
		minEnd[0] = numbers[0];
		int result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > 0) {
				maxEnd[i] = Math.max(numbers[i], maxEnd[i - 1] * numbers[i]);
				minEnd[i] = Math.min(numbers[i], minEnd[i - 1] * numbers[i]);
			} else {
				maxEnd[i] = Math.max(minEnd[i - 1] * numbers[i], numbers[i]);
				minEnd[i] = Math.min(maxEnd[i - 1] * numbers[i], numbers[i]);
			}
			result = Math.max(result, maxEnd[i]);
		}
		System.out.println(result);
	}
}
