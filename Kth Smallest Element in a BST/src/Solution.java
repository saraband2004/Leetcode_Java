import java.io.*; 
import java.util.*; 
import java.lang.*;

class Node{
	public Node left;
	public Node right;
	public int val;
	public Node (int val) {
		this.val = val;
	}
}

class BinarySearchTree{
	public Node root;
	public BinarySearchTree() {
		root = new Node (Integer.MIN_VALUE);
	}
	private boolean Insert (int val, Node root) {
		if (root.val == val) {return false;}
		if (val > root.val) {
			if (root.right == null) {
				Node right = new Node (val);
				root.right = right;
				return true;
			}
			else return Insert (val, root.right);
		}
		else if (val < root.val) {
			if (root.left == null) {
				Node left = new Node (val);
				root.left = left;
				return true;
			}
			else return Insert (val, root.left);
		}
		return false;
	}
	public boolean insert(int val) {
		if (root.right == null) {
			root.right = new Node (val);
			return true;
		}
		return Insert(val, root);
	}
	public boolean delete(int val) {
		Node top = find(val, root);
		if (top == root) {
			Node next = top.right;
			Node p;
			if (next.left!=null && next.right!=null) { 
				p = next.left;
				while (p.right!=null) { p = p.right;}
				int temp = p.val;
				delete(p.val);
				next.val = temp;
				return true;
			}
			else if (next.right==null) { 
				top.right = next.left;
				return true;
			}
			else {
				top.right = next.right;
				return true;
			}
		}
		Node next= top.left;
		if (top.right!=null && top.right.val == val) {
			next = top.right;
		}	
		if (next.left == null) {
			if (top.right!=null && top.right.val == val) {
				top.right = next.right;
			}
			else if (top.left!=null && top.left.val == val) {
				top.left = next.right;
			}
		}
		else if (next.right == null) {
			if (top.right!=null && top.right.val == val) {
				top.right = next.left;
			}
			if (top.left!=null && top.left.val == val) {
				top.left = next.left;
			}
		}
		else if (next.left!=null && next.right !=null) {
			Node p = new Node (333);
			Node q = p;
			q.left = next.right;
			
			while (q.left.left != null) {
				q = q.left;
			}
			next.val = q.left.val;
			if (q.left != next.right) {
				q.left = q.left.right;
			}
			if (q.left == next.right) {
				next.right = next.right.right;
			}
			
		}
		return false;
	}
	
	public Node find (int val, Node root) {
		if (this.root == root) {
			if (root.right.val == val) {return root;}
			else return find(val, root.right);
		}
		
		if (root.right!=null && val == root.right.val) {return root;}
		if (root.left!=null && val == root.left.val) {return root;}
		if (val > root.val) {return find(val, root.right);}
		if (val < root.val) {return find(val, root.left);}
		return null;
	}
 
	public void inorder(Node root) {
		if (root == null) {return;}
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
		
	}
	
	
}



public class Solution {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree BST = new BinarySearchTree();
		
		Random ran = new Random();
		BST.insert(9);
		for (int i =0; i<100; i++) {
			BST.insert(ran.nextInt(10));
		}


		
		BST.inorder(BST.root.right);
		System.out.println();
		BST.delete(5);
		BST.inorder(BST.root.right);
		//System.out.println(BST.find(1, BST.root).right.val);
		
		
	}   
 

}
