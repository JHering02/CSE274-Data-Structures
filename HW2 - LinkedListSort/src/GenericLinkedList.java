import java.util.NoSuchElementException;

/**
 * This is the linked list class which will be able to modify and utilize the
 * Adress class.
 * 
 * @author James Hering (CSE 274, 22 September 2022)
 *
 */
public class GenericLinkedList<T> {
	private Node<T> head;
	private int size = 0;

	/*
	 * Creates an empty list.
	 */
	public GenericLinkedList() {
		head = null;
		size = 0;
	}

	/*
	 * Returns a space-separated list of the elements in the list. If the list has
	 * no elements, return an empty string ("")
	 */
	public String toString() {
		return null;
	}

	/**
	 * Method used to add a new Node to the singly LinkedList.
	 * 
	 * @param newEntry The new data entry
	 */
	public void insert(T newEntry) {
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
	 * Method used to remove the top element from the singly LinkedList.
	 */
	public T remove() {
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
	 * Returns the head of the singly LinkedList. If the list is empty, throw an
	 * IndexOutOfBoundsException.
	 */
	public T getFirst() {
		if (this.size == 0) {
			throw new NoSuchElementException();
		} else {
			T res = (T) head.data;
			return res;
		}
	}

	/*
	 * Returns the item at the specified index. If the index is not valid, throw an
	 * IndexOutOfBoundsException.
	 */
	public T getAt(int index) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> temp = head;
		int current = 0;
		while (current != index) {
			current++;
			temp = temp.next;
		}
		return temp.data;
	}

	/*
	 * Returns the number of elements in the list.
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Returns whether or not the list is empty.
	 */
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Cleans the list and removes all Nodes.
	 */
	public void clear() {
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
