package algorithms.geeksforgeeks;

import java.util.Stack;

public class TreeNextInorderNode {
	public static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		public TreeNode(int val) {
			this.value = val;
		}
	}
	
	
	private TreeNode nextIndorderSucessorWithoutParent(TreeNode root,TreeNode node) {
		
		if(root == null){
			return null;
		}
		TreeNode prev = null;
		while(root != null){
			if(node.value < root.value){
				prev = root;
				root = root.left;
			}
			else {
				root = root.right;
			}
		}
		return prev;
	
	}

	private TreeNode nextIndorderSucessor(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			return leftMostNode(node.right);
		} else {
			TreeNode parent = node.parent;
			TreeNode temp = node;
			while (temp != null && parent.right == temp) {
				temp = parent;
				parent = temp.parent;
			}
			return parent;
		}
	}

	private TreeNode leftMostNode(TreeNode node) {

		while (node.left != null) {
			node = node.left;
		}
		return node;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(4);
		//root.left.parent = root;
		root.right = new TreeNode(11);
		//root.right.parent = root;
		root.left.left = new TreeNode(3);
		//root.left.left.parent =root.left.left;
		root.left.right = new TreeNode(7);
		//root.left.right.parent =root.left.right;
		root.left.right.left = new TreeNode(5);
		//root.left.right.left.parent =root.left.right.left;
		root.left.right.right = new TreeNode(6);
		//root.left.right.right.parent =root.left.right.right;
		System.out.println(new TreeNextInorderNode().nextIndorderSucessorWithoutParent(root,root.right).value);

	}

}
