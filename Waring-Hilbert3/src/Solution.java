import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
	
    public int numCubes(int n) {
        
        return NUMCUBE(n, n);
    }
    public int NUMCUBE(int n, int depth) {
    	if (n == 0) {return 0;}
    	if (depth <= 0) {return n;}
    	int min=n;
    	int root = (int) Math.cbrt(n);
    	while (root >=1) {
    		if (n-root*root*root>=0) {min=Math.min(min, 1+NUMCUBE(n-root*root*root, depth-1));}
    		depth=Math.min(depth, min-1);
    		root--;
    		
    		if (depth!=0 && root*root*root < Math.max(1,n/depth)) {break;}
    	}
    	
    	return min;
    }

	

    public int numCubes2(int n) {
        
        return NUMCUBE2(n, n);
    }
    public int NUMCUBE2(int n, int depth) {
    	if (n == 0) {return 0;}
    	if (depth <= 0) {return n;}
    	int min=n;
    	int root = (int) Math.cbrt(n);
    	while (root >=1) {
    		if (n-root*root*root>=0) {min=Math.min(min, 1+NUMCUBE2(n-root*root*root, depth-1));}
    		depth=Math.min(depth, min-1);
    		root--;
    		
    		//if (depth!=0 && root*root*root < Math.max(1,n/depth)) {break;}
    	}
    	
    	return min;
    }

    
    
	
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		Solution S=new Solution();
		int max=0;
		int temp =0;
		int example = 1;
		
		for (int i=1; i<40000; i++) {
			if (new Solution().numCubes(i)!=new Solution().numCubes2(i)) {System.out.println("error");}
		}
		
		System.out.println(new Solution().numCubes(239));
		//System.out.println((int)Math.sqrt(9));
		System.out.println(example);
	}

}
