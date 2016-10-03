package algorithms.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
	public int solution(int[] A, int D) {

		if (D > A.length) {
			return 0;
		}
		int interval = D;
		int result = -1;
		Map<Integer, List<Integer>> levels = new TreeMap<>();
		for (int i = 0; i < A.length; i++) {
			if (levels.containsKey(A[i])) {
				levels.get(A[i]).add(i);
			} else {
				List<Integer> row = new ArrayList<>();
				row.add(i);
				levels.put(A[i], row);
			}
		}
		int stones[] = new int[A.length + 1];
		stones[A.length] = 1;
		for (Map.Entry<Integer, List<Integer>> timeSlot : levels.entrySet()) {
			for (Integer stone : timeSlot.getValue()) {
				stones[stone] = D;
			}
			if(minJumps(stones) != -1)
			return (timeSlot.getKey());

		}
		return result;
	}

	int minJumps(int arr[]) {
		int n = arr.length;
		int dp[] = new int[arr.length];
		dp[0] = 0;
		for (int i = 0, next = 1; i < n && next < n; i++) {
			if (i == next - 1 && arr[i] == 0)
				return -1;
			for (int j = next; j < n && j <= i + arr[i]; j++, next++) {
				dp[j] = 1 + dp[i];
			}
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] { 1, -1, 0, 2, 3, 5 }, 3));
	}
}