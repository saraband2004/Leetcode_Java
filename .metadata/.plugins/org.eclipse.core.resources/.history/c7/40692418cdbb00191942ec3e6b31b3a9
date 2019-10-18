import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
	
    public int numSquares(int n) {
        int i = 1;
        int m;
        ArrayList <Integer> list = new ArrayList<>();
        ArrayList <Integer> list2 = new ArrayList<>();
        while ( (m=i*i) <= n ) {
            list.add( m );
            i++;
        }
        i = list.size()-1;
        
        while (i >= 0) {
        	list2.add(list.get(i));
        	i--;
        }
        
        list=list2;
      //  System.out.println(list);
        
      //  int [] result= new int [n+1];
        
        return NUMSQ(n, list, n);
    }
    public int NUMSQ(int n, ArrayList<Integer> list, int depth) {
    	
    	if (n == 0) {return 0;}
    	
    	if (depth <= 0) {return n;}
    	
    	int min=n;
    	
    	for (int m: list) {
    		if (n-m>=0) {min=Math.min(min, 1+NUMSQ(n-m, list, depth-1));}
    		//System.out.println(min);
    		depth=Math.min(depth, min-1);
    		//System.out.println(depth);
    	}
    	
    	//result[n]=min;
    	return min;
    }

	
	
	
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		Solution S=new Solution();
		int max=0;
		int temp = 60;
		System.out.println(temp+": "+S.numSquares(temp));
//		for (int i=5000; i<6000; i++) {
//			System.out.println(i+" HELLO "+S.numSquares(i));
//		}
//		
		//System.out.println("max: "+max);

	}

}
