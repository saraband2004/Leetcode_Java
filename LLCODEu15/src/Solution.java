import java.io.*; 
import java.util.*; 
import java.lang.*;
import java.util.List;
import java.util.NoSuchElementException;


class PeekingIterator<E> implements Iterator<E> {
    E next;
    Iterator<E> iterator;
    boolean isEnd;

    public PeekingIterator(Iterator<E> iterator) {
        this.iterator = iterator;
        advance();
    }

    public E peek() {
        if (isEnd)
            throw new NoSuchElementException();
        return next;
    }

    // isEnd() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public E next() {
        if (isEnd)
            throw new NoSuchElementException();
        E res = next;
        advance();
        return res;
    }

    @Override
    public boolean hasNext() {
        return !isEnd;
    }

    private void advance() {
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            isEnd = true;
        }
    }
}
class Solution {
	
	public static void main(String[] args) {
		HashSet<String> set=new HashSet<>();
		set.add("a");
		set.add("bb");
		set.add("ccc");
		set.add("dddd");
		set.add("eeeee");
		set.add("FFFFFF");
		
		Iterator ITE =set.iterator();
		PeekingIterator PITE = new PeekingIterator(ITE);
		while (PITE.hasNext()) {
			System.out.println(PITE.next());
			System.out.println(PITE.peek());
		}
	}
}
