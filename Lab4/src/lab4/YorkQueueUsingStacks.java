package lab4;

import java.util.*;

//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Bartolomeo Gisone
//Yorku Email : -------------
//Date : June 26, 2024
//Authenticity Declaration :
//I declare this submission is the result of my own work and has not been
//shared with any other student or 3rd party content provider.This submitted
//piece of work is entirely of my own creation.
//////////////////////////////
/*
* <p>
* Your implementation of this class or methods should not contains:
* 1. No System.out.println statements should appear here. Instead, you need to
* return the result. 2. No Scanner operations should appear here (e.g.,
* input.nextInt()). Instead, refer to the input parameters of this method.
* </p>
*/

/**
 * 
 * Implement the queue interface using two stacks 
 * 
 * @param <E>
 */

public class YorkQueueUsingStacks<E> implements Queue<E> {
	
	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	Stack<E> s1 = new YorkArrayStack<>();
	Stack<E> s2 = new YorkArrayStack<>();
	int size = 0;
	
	

	public YorkQueueUsingStacks(){
		this.s1 = new YorkArrayStack<>();
		this.size = 0;
	//	this.s2 = new YorkArrayStack<>();
		
		// TODO: Your implementation of this method starts here
	}
	
	
	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		if (this.size<0) throw new NoSuchElementException("negative size is invalid");
		return this.size;
	
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		boolean empty = false;
		if (size<=0) empty=true;
		return empty;
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		this.s1 = new YorkArrayStack<>();
		this.size = 0;
		
	}

	@Override
	public void enqueue(E e) {
		// TODO: Your implementation of this method starts here
		while (!s1.isEmpty())
        { 
            s2.push(s1.pop());
        }
		s2.push(e);
		this.size++;
		
		//put back
		while (!s2.isEmpty())
        { 
            s1.push(s2.pop());
        }
	
	}
	@Override
	public E first() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if (size==0) throw new NoSuchElementException("no first in queue");
		return s1.top();

	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if(size==0) throw new NoSuchElementException("cant remove from empty stack");
		E value = s1.top();
		s1.pop();
		this.size--;
		return value;	
	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (e==null) throw new NullPointerException("invalid element");
		
		boolean contains = false;
		while (!s1.isEmpty())
        { 
			if(s1.top().equals(e)) contains=true;
            s2.push(s1.pop());
        }
		//put back
		while (!s2.isEmpty())
        { 
            s1.push(s2.pop());
        }
		return contains;
	}
	
	
	/**
	 * 
	 *  Return String value represent the content of queue as 
	 * example "[30, 110, -110, -2, 1322]"
	 * 
	 * remember that you should displays the contents of the queue in insertion order (FIFO), so the
	 * most-recently inserted element should be the last element
	 * 
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		if(size==0) return "[]";
		String str = "[";
		while (!s1.isEmpty())
        { 
			str = str + s1.top() + ", ";
            s2.push(s1.pop());
        }
		
		//put back
		while (!s2.isEmpty())
        { 
            s1.push(s2.pop());
        }
		str = str.substring(0, str.length() - 2);
		str = str + "]";
		return str;
	}
	

}
