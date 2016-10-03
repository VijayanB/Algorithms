package algorithms.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {
	public static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	//	inorderTraversal(root);
		List<Integer> data = new ArrayList<>();
		preOrderTraversal(root, data);
		for(Integer a : data){
			System.out.print(a);
		}
	}

	private static void inorderTraversal(Node root) {

		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.val);
		inorderTraversal(root.right);

	}
	
	private static void preOrderTraversal(Node root,List<Integer> data){
		data.add(root.val);
		if(root.left != null){
			preOrderTraversal(root.left, data);
		}
		if(root.right != null){
			preOrderTraversal(root.right, data);
		}
	}

}
