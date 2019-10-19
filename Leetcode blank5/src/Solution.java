import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
	public static void swap(int[] x) {
		x[0] = x[0]^x[1];
		x[1] = x[0]^x[1];
		x[0] = x[0]^x[1];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		System.out.println("Hello JAVA");
		
		int [] x = {222222222, 333333333};
		swap(x);
		System.out.println(x[0]+ " " + x[1]);
	}

}
