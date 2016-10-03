package algorithms.geeksforgeeks.bloomberg;

import java.util.StringTokenizer;

public class StringOptimizer {
	public static void main(String a[]) {
		String str = "String    With Multiple      Spaces";
		String[] st = str.split(" ");
		StringBuffer sb = new StringBuffer();
		for (String s : st) {
			if (!s.equals(""))
				sb.append(s).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}
