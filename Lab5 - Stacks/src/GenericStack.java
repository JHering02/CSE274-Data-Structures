import java.util.NoSuchElementException;

/**
 * Complete the empty methods so that this class works with 
 * the StackDriver.java class given.  You may implement
 * using either a LinkedList or an array.  You MAY NOT use
 * the Java library Stack, LinkedList, or ArrayList classes.
 * 
 * @author john1819, James Hering (CSE 274, 21 September 2022)
 *
 */
public class GenericStack<T> implements StackInterface<T> {
	private Node<T> head;
	private int size = 0;
	
	/**
	 * Method used to push a new Node to the stack.
	 * 
	 * @param newEntry the new data entry
	 */
	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		if (head == null) {
			this.head = new Node<T>(newEntry);
		} else {
			Node<T> temp = new Node<T>(head.data);
			temp.next = head.next;
			this.head = new Node<T>(newEntry);
			this.head.next = temp;
		}
		size++;
	}

	/**
	 * Method used to remove the top element from the stack.
	 */
	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (this.size == 0) {
			throw new NoSuchElementException();
		} else {
			T res = head.data;
			head = head.next;
			size--;
			return res;
		}
	}

	/**
	 * Returns the head of the stack.
	 */
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (this.size == 0) {
			throw new NoSuchElementException();
		} else {
			T res = (T)head.data;
			return res;
		}
	}

	/**
	 * Returns whether or not the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Cleans the stack and removes all Nodes.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = new Node<T>(null);
		size = 0;
	}

}

	/**
	 * A Node class in order to hold generic data types.
	 * 
	 * @author James Hering
	 * @param <T>
	 */
class Node<T> {
	T data;
	Node<T> next;

	// Constructs a new node with the specified data
	Node(T data) {
		this.data = data;
		this.next = null;
	}
}


