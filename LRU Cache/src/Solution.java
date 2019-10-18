import java.io.*; 
import java.util.*; 
import java.lang.*;
class ListNode{
	public int key;
	public int value;
	public ListNode next;
	
	public ListNode(int _key, int _value) {
		key=_key;
		value=_value;
		next=null;
	}
}


class LRUCache {
	public int CAP;
	public int realsize;
	public ListNode DUMMY;
	public HashMap<Integer, ListNode> MAP;
    public LRUCache(int capacity) {
    	realsize=0;
    	CAP=capacity;
    	DUMMY =new ListNode(-99,-88);
    	MAP=new HashMap<>();
    }
    
    public int get(int key) {
        if(CAP==1){
            if (realsize ==0)return -1;
            
            if (realsize ==1){
                if (DUMMY.next.key==key){return DUMMY.next.value;}
                return -1;
            }
            return -1;
            
        }
        
        
        if (MAP.containsKey(key)) {
        	
        	
        	ListNode p=MAP.get(key);
        	if (p == DUMMY) {return p.next.value;}
        	
        	ListNode q=p.next;
        	
        	MAP.put(key, DUMMY);
        	MAP.put(DUMMY.next.key, q);
        	if ( q.next!=null ) { MAP.put(q.next.key, p); }
        	
        	p.next=q.next;
        	q.next=DUMMY.next;
        	DUMMY.next=q;
        	
        	return DUMMY.next.value;
        	// more
        	
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (MAP.containsKey(key)) {
        	
        	ListNode p=MAP.get(key);
        	p.next.value=value;
        	if (p==DUMMY) {return;}
        	ListNode q=p.next;
        	MAP.put(DUMMY.next.key, q);
        	MAP.put(q.key, DUMMY);
        	if (q.next!=null) {MAP.put(q.next.key, p);}
        	
        	p.next=p.next.next;
        	q.next=DUMMY.next;
        	DUMMY.next=q;
        	
        	
        	
        	return;
        	
        }
        
        if (realsize < CAP) {
    		ListNode node=new ListNode(key, value);
	    	node.next=DUMMY.next;
	    	if (DUMMY.next!=null) { MAP.put(DUMMY.next.key, node); }
	        MAP.put(key, DUMMY);
	        DUMMY.next=node;
	        realsize++;
        }    else if (CAP == 1){
            
            DUMMY.next.key=key;
            DUMMY.next.value=value;
            
        }
        
        else if (realsize == CAP) {
        	ListNode p=DUMMY;
        	ListNode q;
        	while(p.next.next!=null) {
        		p=p.next;
        	}
        	q=p.next;
        	MAP.remove(q.key);
        	MAP.put(DUMMY.next.key, q);
        	p.next=null;
        	q.next=DUMMY.next;
        	q.key=key;
        	q.value=value;
        	DUMMY.next=q;
        	MAP.put(q.key , DUMMY);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



  



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LRUCache cache=new LRUCache(10);
	
		for (int i=1; i<20; i++) {
			cache.put(i,-i);
		}
		System.out.println(cache.get(16));
		for (int i=17; i<25; i++) {
			cache.put(i,-i);
		}
		System.out.println(cache.get(15));
	}

}
