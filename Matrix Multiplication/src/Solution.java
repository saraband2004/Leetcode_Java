import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
	public static void testxnonzero(int[][]A, HashSet<Integer> set1) {
		//HashSet<Integer> set1=new HashSet<>();
		boolean test=true;
		for (int y=0; y<A[0].length; y++) {
			for (int x=0; x<A.length; x++) {
				if (A[x][y]!=0) { test=false; break;}			
			}
			
			if (!test) {set1.add(y);}
			test=true;
		}
		
		
	}
	
	
	public static void testznonzero(HashSet<Integer> set1, int[][]B, HashSet<Integer> set2, List<Integer> list) {
		
		boolean test=true;
		for (int y=0; y<B.length; y++) {
			for (int z=0; z<B[0].length; z++) {
				if (B[y][z]!=0) { test=false; break;}			
			}
			
			if (!test) {set2.add(y);
				if (set1.contains(y)) {
					list.add(y);					
				}
			}
			test=true;
			
		}
		
			
	}
	
	
	
	 public static int[][]  multiply_slow(int[][] A, int[][] B) {
	        // write your code here
		 	int [][] C=new int [A.length][B[0].length];
		 	int temp;
		 	HashSet<Integer> set1=new HashSet<>();
		 	HashSet<Integer> set2=new HashSet<>();
		 	testxnonzero(A, set1);
		 	List<Integer> list=new LinkedList<>();
		 	testznonzero(set1, B, set2,list);
		 	for (int x=0; x<A.length;x++) {
		 	
		 		for (int z=0; z<B[0].length;z++) {
		 			temp=0;
		 			for (int Y: list) {
		 				temp+=A[x][Y]*B[Y][z];
		 				
		 			}
		 			
//		 			for (int y=0; y<B.length;y++){
//		 				if (set1.contains(y) && set2.contains(y)) {
//		 				
//		 					temp+=A[x][y]*B[y][z];
//		 				}
//		 				
//		 			}
		 			C[x][z]=temp;
		 		}
		 	}
		 	return C;
		 
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]A={{1,0,0},{-1,0,3}};
		int [][]B={{7,0,0},{0,0,0},{0,0,1}};
		
		multiply_slow(A,B);

	}

}
