import java.util.*; 

class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
}
 

public class Solution {
	
	public static List<String> binaryTreePaths(TreeNode root) {
        // write your code here
		List <String> result=new ArrayList<>();
		if (root==null) {return result;}
		String path=new String();
		//path=Integer.toString(root.val);
		binaryTreePathsII(path, root, result);
		return result;
    }
	
	public static int kthSmallest(TreeNode root, int k) {
        // write your code here
		List <Integer> list=new ArrayList<>();
		
		kthSmallestII(root, list);
		return list.get(k-1);
    }
	public static void kthSmallestII(TreeNode root, List<Integer> list) {
		if (root == null) {return;}
		kthSmallestII(root.left, list);
		list.add(root.val);
		kthSmallestII(root.right, list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void binaryTreePathsII(String path, TreeNode root, List<String> result) {
        // write your code here
		String pathnew=new String(path);
		if (!path.isEmpty() ) {pathnew=pathnew+"->"+Integer.toString(root.val);}
		else {pathnew=Integer.toString(root.val);}
		
		
		
		
		
		if (root.left==null && root.right==null) {
			result.add(pathnew);
		//	System.out.println(pathnew);
		}else if ( root.left != null && root.right != null) {
			binaryTreePathsII(pathnew, root.left, result);
			binaryTreePathsII(pathnew, root.right, result);
		}else if ( root.left != null ) {
			binaryTreePathsII(pathnew, root.left, result);
			
		}else if (  root.right != null) {
			
			binaryTreePathsII(pathnew, root.right, result);
		}
		

		
		
    }
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.print("xxx");
			
//			Stack<Integer> S=new Stack<>();
//			S.add(1);
//			S.add(2);
//			S.add(3);
//			S.pop();
//			System.out.println(S.peek());
			TreeNode l1=new TreeNode(1);
			TreeNode l2=new TreeNode(2);
			TreeNode l3=new TreeNode(3);
			TreeNode l4=new TreeNode(4);
			TreeNode l5=new TreeNode(5);
			TreeNode l6=new TreeNode(6);
			TreeNode l7=new TreeNode(7);
			l1.left=l2;
			l1.right=l3;
			l2.left=l4;
			l2.right=l5;
			l3.left=l6;
			l3.right=l7;
			
			binaryTreePaths(l1);
			
			String path="abc";
			String pathnew=new String();
			pathnew=path;
			System.out.println(path);
			path="aaaa";
			System.out.println(path);
			
			pathnew+="xxxx"+Integer.toString(100);
			System.out.println(pathnew);
			
			kthSmallest(l1,2);
			
			List<Integer> list=new ArrayList<>();
			list.add(000);
			list.add(111);
			list.add(222);
			list.add(333);
			
			
			System.out.println(list.get(1));
			
	}

}
