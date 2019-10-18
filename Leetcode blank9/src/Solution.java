import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
    public List<String> letterCombinations(String digits) {
    	char[]c = digits.toCharArray();
    	for (int i = 0; i<c.length; i++) {
    		if (c[i] <= '7') {c[i] = (char)(((int)(c[i] - '2'))*3 + 'a');}
    		else if (c[i] == '8') {c[i] = 't';}
    		else if (c[i] == '9') {c[i] = 'w';}
    	}
    	
    	List<String> result = new LinkedList<>();
    	int i = 0;
    	while ( true ) {
    		i = 0;
    		result.add(new String(c));
    		System.out.println(new String(c));
    		while (	true ) {
    			if (c[i] == 'c'||c[i] == 'f'||c[i] == 'i'||c[i] == 'l'||c[i] == 'o'||c[i] == 'r') {
    				c[i] -= 2;
    				
    			}
    			else if (c[i] == 's'||c[i] == 'z') {
    				c[i] -= 3;
    			}
    			else {
    				c[i] ++;
    			 
    				break;
    			}
    			i++;
    			if (i == c.length) {return result;}
    		}
    	}
    	//return result;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		System.out.println("Hello JAVA");
		new Solution().letterCombinations("29");
	}

}
