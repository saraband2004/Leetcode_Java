import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
	
    public int numSquares(int n) {
        int i = 1;
        
        int root = (int) Math.sqrt(n);
        
        return NUMSQ(n, n);
    }
    public int NUMSQ(int n, int depth) {
    	
    	if (n == 0) {return 0;}
    	
    	if (depth <= 0) {return n;}
    	
    	int min=n;
    	
    	int root = (int) Math.cbrt(n);
    	    	
    	while (root >=1) {
    		if (n-root*root*root>=0) {min=Math.min(min, 1+NUMSQ(n-root*root*root, depth-1));}
    		//System.out.println(min);
    		depth=Math.min(depth, min-1);
    		//System.out.println(depth);
    		root--;
    	}
    	
    	//result[n]=min;
    	return min;
    }

	
	
	
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		Solution S=new Solution();
		int max=0;
		int temp =0;
		System.out.println(temp+": "+S.numSquares(temp));
		for (int i=1; i<10000; i++) {
			temp=S.numSquares(i); 
			max=Math.max(temp, max);
			System.out.println(i+":"+temp);
		}
		
		System.out.println("max: "+max);
		//System.out.println((int)Math.sqrt(9));
	}

}
