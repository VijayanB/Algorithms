package algorithms.geeksforgeeks;

public class StringToLong {
	/*
	 * Complete the function below.
	 */
	static long parseLong(String str) {
		int start = 0;
		int signBit = 1;
		long strToNum = 0;
		// base condition
		if (str == null || str.length() == 0) {
			throw new java.lang.NumberFormatException();
		}
		char sign = str.charAt(0);
		if (sign == '-') {
			signBit = -1;
			start = 1;
		} else if (sign == '+') {
			start = 1;
		}

		for (int i = start; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				strToNum = strToNum * 10 + (str.charAt(i) - '0');
			} else {
				throw new java.lang.NumberFormatException();
			}
		}
		return strToNum * signBit;
	}

	public static void main(String[] args) {
		 String str = String.valueOf(Integer.MIN_VALUE);
		System.out.println(Integer.valueOf(str));
		long l = parseLong(str);
		if (l == Integer.MIN_VALUE) {
			System.out.println("Success...");
		} else {
			System.out.println("Failure");
		}
	}

	private static long stringToLong(String string) {
		int length = string.length();
		boolean neg = string.startsWith("-");
		boolean endsWithL = Character.toLowerCase(string.charAt(length - 1)) == 'l';

		int start = neg ? 1 : 0;
		int end = endsWithL ? length - 1 : length;

		long result = 0;

		for (int i = start; i < end; i++) {
			char c = string.charAt(i);
			result = result * 10 + Character.digit(c, 10);
		}

		return neg ? -result : result;
	}

}
