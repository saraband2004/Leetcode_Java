import java.io.*; 
import java.util.*; 
import java.lang.*;
class RandomizedSet {
	public int size;
	public int [] store;
	public boolean [] status;
	public boolean [] removed;
	public int CNST;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        size = 0;
        CNST=2;
        store = new int [CNST];
        status = new boolean[CNST];
        removed= new boolean[CNST];
    }
    public int hashfunction(int x) {
    	return Math.abs(x*33)%(store.length);
    }
    	
    public void resize() {
    	int z = CNST * size;
    	if (size == 0) {return;}
    	if (store.length <= z+1 && z <= store.length+1) {
    		return;
    	}
    	
    	int [] oldstore = store;
    	boolean[]oldstatus = status;
    	store = new int[z];
    	status= new boolean[z];
    	removed =new boolean[z];
    	for (int i = 0; i<oldstore.length; i++) {
    		if (oldstatus[i]) {
    			insert(oldstore[i]);
    		}
    	}
    	//System.out.println("R-E-S-I-Z-E");
    }
    
    
    
    
    
    
    
    
    
    
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	int position = hashfunction(val);
    	while (status[position] || removed[position]) {
    		if (status[position] && store[position] == val) {return false;}
    		position++;
    		if (position == status.length) {
    			position = 0;
    		}
    	}
    	position = hashfunction(val);
    	while (status[position]) {
    		position++;
    		if (position == status.length) {
    			position = 0;
    		}
    	}
    	
    	status[position] = true;
    	store[position] = val;
    	removed[position] = false;
    	size++;
    	resize();
    	return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	int position = hashfunction(val);
    	while (status[position] || removed[position]) {
    		if (status[position] && store[position] == val) {
    			status[position] = false;
    			store[position]=-999;
    			removed[position]=true;
    			size--;
    			resize();
    			return true;}
    		position++;
    		if (position == status.length) {
    			position = 0;
    		}
    	}
    	resize();
    	return false;
    	
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int u;
        while (!status[u=rand.nextInt(store.length)]) {
        	
        }
        return store[u];
    }
}

public class Solution {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String s="Wrong answer or accepted?";
		System.out.println(s);
		
	}

}
