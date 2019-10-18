import java.io.*; 
import java.util.*; 
import java.lang.*;

class TreeNode{
    public char letter;
    public TreeNode[]next;
    public boolean word;
    TreeNode(char x){
    	letter=x;
    	next=new TreeNode[26];
    	word=false;
    }
    
}


class WordDictionary {
	public TreeNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new TreeNode('#');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode p=root;
        char[]c=word.toCharArray();
        int index=0;
        while (index <= c.length) {
        	if (index == c.length) {
        		p.word=true;
        	}
        	else if (p.next[c[index]-'a']!=null) {
        		p=p.next[c[index]-'a'];
        		
        	}
        	else {
        		p.next[c[index]-'a']=new TreeNode(c[index]);
        		p=p.next[c[index]-'a'];
        	}
        	index++;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search2(String word) {
        TreeNode p=root;
        char[]c=word.toCharArray();
        int index=0;
        while (index <= c.length) {
        	if (index == c.length) {
        		return p.word;
        	}
        	else if (p.next[c[index]-'a']!=null) {
        		p=p.next[c[index]-'a'];
        		
        	}
        	else {
        		return false;
        	}
        	index++;
        }
        return true;
    }
    
    public boolean search(String word) {
        TreeNode p=root;
        char[]c=word.toCharArray();
        
        return Searchelp(c, 0, p);
    }
    public boolean Searchelp(char[]c, int index, TreeNode p) {
    	if (index==c.length) {return p.word;}
    	
    	if (c[index]=='.') {
    		boolean test=false;
    		for (int i=0; i< 26; i++) {
    			if (p.next[i]!=null) {
    				test=test||Searchelp(c,index+1, p.next[i]);
    				if (test) {return test;}
    			}
    		}
    		return test;
    	}
    	
    	if (p.next[c[index]-'a']!=null) {
    		return Searchelp(c,index+1, p.next[c[index]-'a']);
    	}
    	return false;
    	
    }
}
    
    


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("aaa");
		WordDictionary dict=new WordDictionary();
		dict.addWord("aaaaa");
		dict.addWord("aaaab");
		System.out.print(dict.search("aaaaa"));
	}

}
