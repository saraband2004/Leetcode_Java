import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<List<String>> result=new ArrayList<>();
        List<String> temp=new LinkedList<>();
        temp.add("");
        result.add(temp);
        temp=new LinkedList<>();
        temp.add("()");
        result.add(temp);
        
        for (int i=2; i<=n; i++){
            temp=new LinkedList<>();
            for (int j=1; j<=i; j++){
                for (String t1: result.get(j-1)){
                    for (String t2: result.get(i-j)){
                        temp.add("("+t1+")"+t2);
                    }
                }
            }
            result.add(temp);
        }
        return result.get(n);
    }
	
	public static void Catalan(int n) {
		List<String> result=new ArrayList<>();
		String temp=new String ();
		int plus=0;
		int minus=0;
		
		CatalanII(n,plus,minus,temp,result);
		
		//System.out.println(result.size());
		
	} 
	public static void CatalanII(int n, int plus, int minus, String temp, List<String> result) {
		
		
		//if (plus < minus) {return;}
		if (plus == n) {
			if (minus == n) {
				result.add(new String(temp));
				//System.out.println(temp);
				return;
			}
			else {
				//System.out.println("x");
				temp=temp+")";
				CatalanII(n,plus, minus+1, temp, result);
				temp = temp.substring(0, temp.length()-1);
			}
			
		}
		else if (plus == minus) {
			
			temp=temp+"(";
			CatalanII(n,plus+1, minus, temp, result);
			temp = temp.substring(0, temp.length()-1);
			
		}
		
		else if (plus > minus) {
			temp=temp+"(";
			CatalanII(n,plus+1, minus, temp, result);
			temp = temp.substring(0, temp.length()-1);
			temp=temp+")";
			CatalanII(n,plus, minus+1, temp, result);
			temp = temp.substring(0, temp.length()-1);
			
			
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		//System.out.print(true);
		int n=15;
		for (int i=1;i<=n;i++)generateParenthesis(i);
		long endTime = System.nanoTime();
		System.out.println("Took "+((double)(endTime - startTime)/1000/1000/1000) + "s");
		startTime = System.nanoTime();
		
		for (int i=1;i<=n;i++)Catalan(i);
		// code
		endTime = System.nanoTime();
		
		System.out.println("Took "+((double)(endTime - startTime)/1000/1000/1000) + "s");
	}

}
