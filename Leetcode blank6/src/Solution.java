import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
	public int distance (int [] x, int [] y) {
		
		return (x[0]-y[0])*(x[0]-y[0])+(x[1]-y[1])*(x[1]-y[1]);
	}
    public int numberOfBoomerangs(int[][] points) {
    	int N = points.length;
    	int count=0;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if (j == i) continue;
    			for (int k = 0; k < N; k++) {
    				if (k == j)continue;
    				if (k == i)continue;
    				
    				if (distance (points[i], points[j])== distance(points[i], points[k])) {
    					count++;
    				}
    			}
        	}
    	}
    	return count;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		System.out.println("Hello JAVA");
	}

}
