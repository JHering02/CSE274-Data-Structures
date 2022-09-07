import java.util.NoSuchElementException;
/**
 * This is an Overloaded LinkedList Class with various methods.
 * 
 * @author James Hering, CSE 274, 7 September 2022
 */
public class LinkedList {
	
	private Node head;
	private Node tail;
	private int size;	
	
	/*
	 * Creates an empty list.
	 */
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
		
	}
	
	/*
	 * Returns a space-separated list of the elements in the list.
	 * If the list contains no elements, return an empty string ""
	 */
	public String toString() {
		String list = "";
		Node current = head;
		while(current != null) {
			list = list + current.data + " ";
			current = current.next;
		}
		return list;
	}
	
	
	/*
	 * Returns the first item in the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public int getFirst() {
		int res = 0;
		if(this.size == 0) {
			throw new NoSuchElementException();
		} else {
			res = this.head.data;
			return res;
		}
	}
	
	/*
	 * Returns the last item in the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public int getLast() {
		int res = 0;
		if(this.size == 0) {
			throw new NoSuchElementException();
		} else {
			res = this.tail.data;
			return res;
		}
	}
	
	/*
	 * Returns the item at the specified index. If the index
	 * is not valid, throw an IndexOutOfBoundsException.
	 */
	public int getAt(int index) {
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return 0;
	}
	
	/*
	 * Inserts an item at the beginning of the list.
	 */
	public void insertFirst(int num) {
		if(head == null) {
			this.tail = new Node(num);
		} else {
			this.head = new Node(num);
		}
		this.size++;
		
	}
	
	/*
	 * Inserts an item at the end of the list.
	 */
	public void insertLast(int num) {
		Node last = this.head;
		while(last != null) {
			last = last.next;
		}
		last = new Node(num);
		this.size++;
	}
	
	/*
	 * Removes and returns the first element from the list.  If the 
	 * list is empty, throw a NoSuchElementException.
	 */
	public int removeFirst() {
		int res = 0;
		if(this.size == 0) {
			throw new NoSuchElementException();
		} else {
			res = this.head.data;
			this.head = head.next;
			size--;
			return res;
		}
	}
	
	/*
	 * Removes and returns the last element from the list.  If the 
	 * list is empty, throw a NoSuchElementException.
	 */
	public int removeLast() {
		size--;
		return 0;
	}
	
	
	
	/*
	 * Returns the number of elements in the list.
	 */
	public int getSize() {
		return this.size;
	}
	
	/*
	 * Returns true if the list is empty, and false otherwise.
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	
	// A private Node class.  By making it an inner class, 
	// the outer class can access it easily, but the client cannot.	
	private class Node {
		private int data;
		private Node next;

		// Constructs a new node with the specified data
		private Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
