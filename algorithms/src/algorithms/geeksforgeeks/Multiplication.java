package algorithms.geeksforgeeks;

public class Multiplication {
	public static void main(String[] args) {
		String num1 = "2345";
		String num2 = "1";
		String first = new StringBuilder(num1).reverse().toString();
		String second = new StringBuilder(num2).reverse().toString();

		int result[] = new int[first.length() + second.length()];
		for (int i = 0; i < first.length(); i++) {
			for (int j = 0; j < second.length(); j++) {
				result[i + j] += ((first.charAt(i) - '0') * (second.charAt(j) - '0'));
			}
		}
		int carry = 0;
		int sum = 0;
		StringBuilder resultStr = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sum = (result[i] + carry) % 10;
			carry = result[i] / 10;
			resultStr.append(sum);
		}
		if (carry > 0) {
			resultStr.append(carry);
		}
		System.out.println(resultStr.reverse().toString());
	}
}
