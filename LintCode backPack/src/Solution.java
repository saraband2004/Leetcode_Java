import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
    public int backPack(int m, int[] A) {
        // write your code here
    	Arrays.sort(A);
    	int sum = 0;
    	int i = 0;
    	while (sum < m || i < A.length) {
    		sum += A[i];
    		i++;
    	}
    	if (sum == m) {return m;}
    	int maxitem = i - 1;
    	
    	
    	
    	return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		System.out.println("Hello Java");
	}

}
