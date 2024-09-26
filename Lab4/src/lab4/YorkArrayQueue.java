package lab4;

import java.util.*;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Bartolomeo Gisone
//Yorku Email : -------------------
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
 * Queue using expandable circular Array of generic type E. This is called a
 * "circular" queue with expandable array. if the queue (array) is full, create
 * a new queue (array) of twice the size, and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayQueue<E> implements Queue<E> {

	/**
	 * Initial size, default size, for the queue
	 * remember that an empty queue has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	private E[] Queue = (E[]) new Object[INITSIZE];
	int size = 0;
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	
	
	
	/**
	 * No argument constructor
	 */
	public YorkArrayQueue() {
		// TODO: Your implementation of this method starts here
		this.Queue = (E[]) new Object[INITSIZE];
		this.size = 0;
	}

	public YorkArrayQueue(int capacity) {
		// TODO: Your implementation of this method starts here
		if(capacity<=INITSIZE) {
			this.Queue = (E[]) new Object[INITSIZE];
			this.size = 0;
			
		}else {
				
		int newSize = INITSIZE; 
		while(capacity > newSize) {
			newSize = newSize*2;
		}
		this.Queue = (E[]) new Object[newSize];
		this.size = 0;
		}
	}

	/**
	 * Constructor takes array of elements and then add then to the end of the Array
	 * list
	 * 
	 * @param objects
	 */

	public YorkArrayQueue(E[] objects) {
		// TODO: Your implementation of this method starts here
		if (objects==null) throw new NullPointerException("input null object array");
		int newSize = INITSIZE; 
		while(objects.length > newSize) {
			newSize = newSize*2;
		}
		this.Queue = (E[]) new Object[newSize];
		this.size = objects.length;
		for(int i = 0; i < objects.length; i++) {
			Queue[i] = objects[i]; 
		}	
	}

	@Override
	public int size() {
		if (this.size<0) throw new NoSuchElementException("negative size is invalid");
			// TODO: Your implementation of this method starts here		
		return size;

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
		this.Queue = (E[]) new Object[INITSIZE];
		this.size = 0;		
		// TODO: Your implementation of this method starts here
		
	}

	@Override
	public void enqueue(E e) {
		// TODO: Your implementation of this method starts here
		if(e == null) throw new NullPointerException("can't add null element");
		else if(size >= Queue.length) {
			//only runs if extra memory is needed
			E[] temp = (E[]) new Object[size*2];
			for(int i = 0; i< size; i++) {
				temp[i] = Queue[i];
			}
			temp[size] = e;
			this.Queue = temp;
			this.size++;
		}
		else {
			//only runs in no new memory is needed
			this.Queue[size] = e;
			this.size ++;
		}

	}

	@Override
	public E first() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if(this.Queue[0]==null) throw new NoSuchElementException("empty Queue");
		
		return this.Queue[0];
			
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if(size==0) throw new NoSuchElementException("nothing to dequeue");
		if(this.Queue[0] == null) throw new NoSuchElementException("nothing to dequeue");
		E value = this.Queue[0];
		E[] temp = (E[]) new Object[Queue.length];
		for(int i = 0; i< Queue.length-1; i++) {
			temp[i] = Queue[i+1];
		}
		this.size--;
		this.Queue = temp;
		return value;


	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		//if(size<=0) throw new NullPointerException();
		// TODO: Your implementation of this method starts here
		boolean contains = false;
		if (e==null) throw new NullPointerException("invalid element");
		for(int i = 0; i < this.size; i++) {
			if (Queue[i].equals(e)) contains = true;
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
		else {
			String str = "[";
			for(int i = 0; i<size-1; i++) {
				str = str + this.Queue[i]+ ", ";
			}
			str = str + this.Queue[size-1] + "]";
			return str;
		}
	}
	
	



	
	

}
