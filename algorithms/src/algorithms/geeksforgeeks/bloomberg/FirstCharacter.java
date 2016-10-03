package algorithms.geeksforgeeks.bloomberg;

import java.util.HashMap;
import java.util.Map;

public class FirstCharacter {
	public static void main(String[] args) {
		String Str1 = "adf6ysh";
		String Str2 = "123678";

		Map<Character, Integer> auxMap = new HashMap<>();
		int index = 0;
		for (char c : Str2.toCharArray()) {
			auxMap.put(c, index);
			index++;
		}
		index = 0;
		for (char c : Str1.toCharArray()) {
			if (auxMap.containsKey(c)) {
				System.out.println(index);
				break;
			}
			index++;
		}

	}
}
