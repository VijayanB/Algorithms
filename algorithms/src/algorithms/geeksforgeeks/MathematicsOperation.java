package algorithms.geeksforgeeks;

public class MathematicsOperation {
	private static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			next = null;
		}
	}

	public static void main(String[] args) {
		Node first = new Node(0);
		first.next = new Node(1);
		first.next.next = new Node(0);

		Node second = new Node(0);
		second.next = new Node(1);

		print(multiplyTwoNum(first, second));
	}

	private static void print(Node res) {
		while (res != null) {
			System.out.print(res.val + "-->");
			res = res.next;
		}
		System.out.println("NULL");
	}

	private static Node multiplyTwoNum(Node first, Node second) {
		Node res = null;
		int c = 0;
		while (second != null) {
			res = addTwoNum(res, row(first, second.val, c));
			c++;
			second = second.next;
		}
		return res;
	}

	private static Node row(Node num, int val, int prefix) {
		Node first = num;
		Node prev = null;
		Node temp = null;
		Node result = null;
		int carry = 0;
		int res = 0;
		while (first != null) {
			
			res = first.val * val + carry;
			carry = res / 10;
			res = res % 10;
			temp = new Node(res);
			if (result == null) {
				result = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;
			first = first.next;
		}
		if (carry > 0) {
			temp = new Node(carry);
			prev.next = temp;
			prev = temp;
		}
		while (prefix > 0) {
			temp = new Node(0);
			temp.next = result;
			result = temp;

			prefix--;
		}
		return result;
	}

	private static Node addTwoNum(Node first, Node second) {

		int sum = 0, carry = 0;
		Node res = null;
		Node prev = null;
		Node temp;
		while (first != null || second != null) {
			sum = carry + (first != null ? first.val : 0) + (second != null ? second.val : 0);
			carry = sum / 10;
			sum = sum % 10;
			temp = new Node(sum);
			if (res == null) {
				res = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;
			if (first != null) {
				first = first.next;
			}
			if (second != null) {
				second = second.next;
			}
		}

		if (carry > 0) {
			prev.next = new Node(carry);
		}
		return res;
	}
}
