package lab4;

/**
 * A collection of objects that are inserted and removed according to the last-in
 * first-out principle. Although similar in purpose, this interface differs from
 * java.util.Stack.
 *
 */
public interface Stack<E> {

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */
  int size();

  /**
   * Tests whether the stack is empty.
   * @return true if the stack is empty, false otherwise
   */
  boolean isEmpty();

  
  
  	 /**
	 * Removes all the elements from the stack and everything back to the initial
	 * state, including setting its size back to the initial size.
	 * Remember that an empty stack has zero elements
	 */
	public void clear();
  
  
  /**
   * Inserts an element at the top of the stack.
   * Remember that if the stack (array) is full, 
   * create a new stack (array) of twice the size, and copy the elements.
   * 
   * @param e   the element to be inserted
   */
  void push(E e);

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * @return top element in the stack 
   * 
   * @throws java.util.EmptyStackException if stack empty 
   */
  E top() throws java.util.EmptyStackException;

  /**
   * Removes and returns the top element from the stack.
   * 
   * @return element removed 
   * @throws java.util.EmptyStackException() if stack empty 
   */
  E pop();
}
