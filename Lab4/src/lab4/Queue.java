package lab4;

import java.util.*;

/**
 * Interface for a queue: a collection of elements that are inserted and removed
 * according to the first-in first-out principle. Although similar in purpose,
 * this interface differs from java.util.Queue.
 *
 * 
 */
public interface Queue<E> {

	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return number of elements in the queue
	 */
	int size();

	/**
	 * Tests whether the queue is empty.
	 * 
	 * @return true if the queue is empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Removes all the elements from this queue and everything back to the initial
	 * state, including setting its size back to the initial size.
	 * Remember that an empty queue has zero elements
	 */
	public void clear();

	/**
	 * Inserts an element at the rear of the queue. resizing the internal array if
	 * needed.
	 * 
	 * @param e the element to be inserted
	 */
	void enqueue(E e);

	/**
	 * Returns, but does not remove, the first element of the queue.
	 * 
	 * @return the first element of the queue
	 * @throws NoSuchElementException If the queue is empty.
	 * 
	 */
	E first() throws NoSuchElementException;;

	/**
	 * Removes and returns the first element of the queue.
	 * 
	 * @return element removed
	 * @throws NoSuchElementException If the queue is empty.
	 */
	E dequeue() throws NoSuchElementException;
	
	
	/**
	 * Returns {@code true} if this queue contains the specified element. More
	 * formally, returns {@code true} if and only if this queue contains at least one
	 * element {@code e} such that {@code equals(e, element)}.
	 *
	 * @param e element whose presence in this queue is to be tested
	 * @return {@code true} if this queue contains the specified element
	 * 
	 * @throws NullPointerException if the specified element is null 
	 * 
	 */

	boolean contains(E e) throws NullPointerException;
	
	
	
	
}
