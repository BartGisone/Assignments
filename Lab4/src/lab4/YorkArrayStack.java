package lab4;

import java.util.EmptyStackException;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 
import java.util.NoSuchElementException;

///////////////////////////////////////////////////////////////////////////
//Full Name : Bartolomeo Gisone
//Yorku Email : -------------
//Date : June 24, 2024
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
 * Stack using expandable Array of generic type E.
 * if the stack (array) is full, create a new stack (array) of twice the size, and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayStack<E> implements Stack<E> {

	/**
	 * Initial size, default size, for the Array of stack 
	 * remember that an empty stack has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	
	
	
	private E[] Stack = (E[]) new Object[INITSIZE];
	int size = 0;
	

	/**
	 * No argument constructor
	 */
	public YorkArrayStack() {
		// TODO: Your implementation of this method starts here
		this.Stack = (E[]) new Object[INITSIZE];
		this.size = 0;
	}

	public YorkArrayStack(int capacity) {
		// TODO: Your implementation of this method starts here
		if(capacity<=INITSIZE) {
			this.Stack = (E[]) new Object[INITSIZE];
			this.size = 0;
			
		}else {
			int newSize = INITSIZE; 
			while(capacity > newSize) {
				newSize = newSize*2;
			}
			this.Stack = (E[]) new Object[newSize];
			this.size = 0;
			
		}
		
	
	}

	/**
	 * Constructor takes array of elements and then add then to 
	 * the end of the Array list 
	 * @param objects
	 */
	
	public YorkArrayStack(E[] objects) {
		// TODO: Your implementation of this method starts here
		if (objects==null) throw new NullPointerException("input null object array");
		int newSize = INITSIZE; 
		while(objects.length > newSize) {
			newSize = newSize*2;
		}
		this.Stack = (E[]) new Object[newSize];
		this.size = objects.length;
		for(int i = 0; i < objects.length; i++) {
			Stack[i] = objects[i]; 
		}
	  }

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		if (this.size<0) throw new NoSuchElementException("negative size is invalid");
		return this.size;
		
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		this.Stack = (E[]) new Object[INITSIZE];
		this.size = 0;	
	}
	
	
	
	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		boolean empty = false;
		if (size<=0) empty=true;
		return empty;

	}

	
	@Override
	public E top() throws EmptyStackException {
		//  TODO: Your implementation of this method starts here
		if(size==0) throw new EmptyStackException();
		return Stack[size-1];

	
	}
	
	
	
	@Override
	public void push(E e) {
		// TODO: Your implementation of this method starts here
		if(e == null) throw new NullPointerException("can't add null element");
		else if(size >= Stack.length) {
			//only runs if extra memory is needed
			E[] temp = (E[]) new Object[size*2];
			for(int i = 0; i< size; i++) {
				temp[i] = Stack[i];
			}
			temp[size] = e;
			this.Stack = temp;
			this.size++;
		}
		else {
			//only runs in no new memory is needed
			this.Stack[size] = e;
			this.size ++;
		}

	}

	@Override
	public E pop() {
		// TODO: Your implementation of this method starts here
		if(size==0) throw new NoSuchElementException("nothing to dequeue");
		if(this.Stack[0] == null) throw new NoSuchElementException("nothing to dequeue");
		E value = this.Stack[size-1];
		E[] temp = (E[]) new Object[Stack.length];
		for(int i = 0; i< Stack.length-1; i++) {
			temp[i] = Stack[i];
		}
		this.size--;
		this.Stack = temp;
		return value;

	}
	



}
