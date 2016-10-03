package algorithms.geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTravversal {

	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.value = val;
		}
	}

	public List<LinkedList<TreeNode>> levelOrderTraversal(TreeNode root) {
		List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> currentLevel = new LinkedList<>();
		if (root != null) {
			currentLevel.add(root);
		}

		while (currentLevel.size() > 0) {
			result.add(currentLevel);
			LinkedList<TreeNode> parent = currentLevel;
			currentLevel = new LinkedList<>();
			for (TreeNode node : parent) {
				if (node.left != null) {
					currentLevel.add(node.left);
				}
				if (node.right != null) {
					currentLevel.add(node.right);
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		LevelOrderTravversal order = new LevelOrderTravversal();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(2);
		// root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		List<LinkedList<TreeNode>> res = order.levelOrderTraversal(root);
		for (LinkedList<TreeNode> row : res) {
			for (TreeNode cell : row) {
				System.out.print(cell.value + "    ");
			}
			System.out.println();
		}
	}
}
