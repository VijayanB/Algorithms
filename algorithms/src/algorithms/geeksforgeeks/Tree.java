package algorithms.geeksforgeeks;

//PLEASE DO NOT UNCOMMENT THIS BLOCK

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
// No other imports are permitted

// The following definitions of Tree and Node are provided.
// insert and delete will be methods of class Tree.

public class Tree {
    private class Node {
        private int val;
        private Node left = null;
        private Node right = null;
        private Node mid = null;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;


    /* 
     * Please complete this method.
     * Inserts val into the tree.
     */
    public void insert(int val) {
      Node temp = new Node(val);
        if (root == null)
            {
                root = temp;
                return;
            }
        else {
            insert(val,root);
        }
        
    }

   private void insert(int value,Node current){
       if (value < current.val) {
				if (current.left != null)
					insert(value, current.left);
				else
					current.left = new Node(value);
			} else if (value > current.val) {
				if (current.right != null)
					insert(value, current.right);
				else
					current.right = new Node(value);
			} else {
				if (current.mid != null)
					insert(value, current.mid);
				else
					current.mid = new Node(value);
			}
			
   }

    /* 
     * Please complete this method.
     * Deletes only one instance of val from the tree.
     * If val does not exist in the tree, do nothing.
     */
    public void delete(int value) {
        
			if (root == null) return;

            Node current = root;
            Node parent = null;

            while (current != null)         
            {
                if (value > current.val	)
                {
                    parent = current;
                    current = current.right;
                }
                else if (value < current.val)
                {
                    parent = current;
                    current = current.left;
                }
                else break;
            }

            if (current == null) return;
            if (current.mid != null)             
            {                                     
                while (current.mid != null)
                {
                    parent = current;
                    current = current.mid;
                }
                parent.mid= null;
                return;
            }
            
            
            if (current.left == null && current.right == null)   
            {
                if (current == root)
                {
                	root = null;
                }
                else if (parent.left == current) parent.left = null;
                else parent.right = null;
                return;
            }

            
            if (current.left == null)       
            {
                if (current == root)
                {
                	root = current.right;
                }
                else if (parent.left == current) parent.left = current.right;
                else parent.right = current.right;
            }
            else if (current.right == null)
            {
                if (current == root)
                {
                	root = current.left;
                }
                else if (parent.left == current) parent.left = current.left;
                else parent.right = current.left;
            }
            else  
            {
                Node parentofSuccessor = null;
                Node successor =leftMost(current.right);

                if (parentofSuccessor == null)
                {
                    current.val = successor.val;
                    current.right = successor.right;
                }
                else
                {
                    current.val = successor.val;
                    parentofSuccessor.left = successor.right;
                }
            }
    }
		private Node leftMost(Node root) {
			if (root != null) {
				while (root.left != null) {
					return leftMost(root.left);
				}
			}
			return root;
		}


    
		}
