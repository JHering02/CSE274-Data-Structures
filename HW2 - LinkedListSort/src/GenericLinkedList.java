import java.util.NoSuchElementException;

/**
 * This is the linked list class which will be able to modify and utilize the
 * Adress class.
 * 
 * @author James Hering (CSE 274, 22 September 2022)
 *
 */
public class GenericLinkedList<T extends Comparable<T>> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	/*
	 * Creates an empty list.
	 */
	public GenericLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Method used to add a new Node to the singly LinkedList.
	 * 
	 * @param newEntry The new data entry
	 */
	public void insert(T newEntry) {
		Node<T> temp = new Node<T>(newEntry);
		// Setting the new Node to both if the linked list is empty
		if (head == null) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
		size++;
	}

	/**
	 * Method used to remove the top element from the singly LinkedList.
	 */
	public T remove() {
		// Doesn't remove if the list is empty
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
		// Doesn't find anything if the list is empty
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
		// Iterate through the list until the index is found
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

	/**
	 * Allows a call to the mergeSort method.
	 */
	public void sort() {
		head = mergeSort(this.head);
	}

	/**
	 * Begins the recursive merge sort method in order to try and sort the
	 * LinkedList.
	 * 
	 * @param head beginning of the list
	 * @return
	 */
	private Node<T> mergeSort(Node<T> head) {
		// Checking if the head doesn't exist or is empty
		if (head == null || head.next == null) {
			return head;
		}
		// Setting a pivot point
		int currSize = 0;
		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
			currSize++;
		}
		int middleLength = currSize / 2;
		Node<T> mid = head;
		while (middleLength != 0) {
			mid = head.next;
			middleLength--;
		}
		// Setting a Second pivot point for the other half of this bound
		Node<T> nextMid = mid.next;
		mid.next = null;
		// Check if the values can even be compared to sort
		if (Comparable.class.isAssignableFrom(head.data.getClass())) {
			Node<T> left = mergeSort(head);
			Node<T> right = mergeSort(nextMid);
			Node<T> sorted = merge(left, right);
			return sorted;
		}
		// Doesn't return anything if the list cannot be sorted
		return null;
	}

	private Node<T> merge(Node<T> start, Node<T> end) {
		// Declaring a sorted node.
		Node<T> res = null;
		// Checking the 2 bounds
		if (start == null) {
			return end;
		}
		if (end == null) {
			return start;
		}
		// If the 2nd bound is larger, take the first bound
		if (start.data.compareTo(end.data) <= 0) {
			res = start;
			start.next = merge(start.next, end);
		} else {
			res = end;
			res.next = merge(start, end.next);
		}
		// Return the sorted nodes for this bound
		return res;

	}

}

/**
 * A Node class in order to hold generic data types.
 * 
 * @author James Hering
 * @param <T> the generic data type
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
