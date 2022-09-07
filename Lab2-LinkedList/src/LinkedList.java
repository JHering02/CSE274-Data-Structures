
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
		
		return 0;
	}
	
	/*
	 * Returns the last item in the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public int getLast() {
		return 0;
	}
	
	/*
	 * Returns the item at the specified index. If the index
	 * is not valid, throw an IndexOutOfBoundsException.
	 */
	public int getAt(int index) {
		return 0;
	}
	
	/*
	 * Inserts an item at the beginning of the list.
	 */
	public void insertFirst(int num) {
		
		
	}
	
	/*
	 * Inserts an item at the end of the list.
	 */
	public void insertLast(int num) {
		
	}
	
	/*
	 * Removes and returns the first element from the list.  If the 
	 * list is empty, throw a NoSuchElementException.
	 */
	public int removeFirst() {
		return 0;
	}
	
	/*
	 * Removes and returns the last element from the list.  If the 
	 * list is empty, throw a NoSuchElementException.
	 */
	public int removeLast() {
		return 0;
	}
	
	
	
	/*
	 * Returns the number of elements in the list.
	 */
	public int getSize() {
		return -1;
	}
	
	/*
	 * Returns true if the list is empty, and false otherwise.
	 */
	public boolean isEmpty() {
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
