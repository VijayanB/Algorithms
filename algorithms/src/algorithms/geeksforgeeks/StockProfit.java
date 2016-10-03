package algorithms.geeksforgeeks;

public class StockProfit {
	public static void main(String[] args) {
		int stocks[] = new int[] {};
		int min = stocks[0];
		int diff = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 1; i < stocks.length; i++) {
			temp = stocks[i] - min;
			min = Math.min(stocks[i], min);
			diff = Math.max(diff, temp);
		}
		System.out.println(diff);
	}
}
