
/**
 * This class implements a hash table that contains String objects. It has the
 * same methods as the LinkedSet and ResizableArraySet, but uses a hash table as
 * the implementation. Hashtables are combinations of array and linked list
 * implementations.
 * 
 * @author john1819, James Hering CSE 274, 19 October 2022
 *
 */
public class MyHashSet implements Set {

	private Node[] table;
	private int size;
	final int DEFAULT_N = 20;

	/**
	 * Default constructor
	 */
	public MyHashSet() {
		// create the default sized table
		table = new Node[DEFAULT_N];
	}

	/**
	 * Constructor to allow user to set size N of the table
	 * 
	 * @param newN
	 */
	public MyHashSet(int newN) {
		table = new Node[newN];
	}

	@Override
	public boolean add(String s) {
		if (contains(s)) {
			// element already contained in the set- do not add
			return false;
		}
		// not contained need to add
		// get index
		int index = compressHashCode(s);
		// add to front of linked list
		Node newNode = new Node(s);
		newNode.next = table[index];
		table[index] = newNode;
		size++;
		return true;
	}

	@Override
	public boolean remove(String s) {
		if (!contains(s)) {
			// element trying to be removed isn't there
			return false;
		}
		// Contained value has to be removed
		// get index
		int index = compressHashCode(s);
		Node curr = table[index];
		// Finding the corresponding string
		while (curr != null) {
			// Checking if it needs to be removed
			if ((curr.next != null) && curr.next.data.equals(s)) {
				curr.next = curr.next.next;
				size--;
				return true;
			} else if (curr.data.equals(s)) {
				table[index] = curr.next;
				size--;
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	@Override
	public void clear() {
		// set size equal to 0
		for (Node curr : table) {
			if (curr != null) {
				curr.data = null;
				curr.next = null;
			}
		}
		size = 0;
	}

	@Override
	public boolean contains(String s) {
		boolean contained = false;
		// check to see if s is contained in the table
		// step 1- get index of s
		int index = compressHashCode(s);

		// step 2 - get linked list at index
		Node current = table[index];

		// step 3- look through linked list for equality
		while (current != null) {
			if (s.equals(current.data)) {
				contained = true;
				break; // stop the while loop
			}
			current = current.next;
		}
		return contained;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public boolean addAll(String[] strings) {
		boolean completed = false;
		for (String str : strings) {
			add(str);
			completed = contains(str);
		}
		return completed;
	}

	@Override
	public String[] toArray() {
		String[] theArray = new String[size];
		int count = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null) {
				continue;
			}
			Node curr = table[i];
			while (curr != null) {
				theArray[count] = curr.data;
				curr = curr.next;
				count++;
			}
		}
		return theArray;

	}

	/**
	 * This method compresses the default hashCode of an element being stored in the
	 * table and returns an index for storate or retrieval in the table
	 * 
	 * @param hashCode
	 * @return a compressed code suitable for use with hashtable
	 */
	private int compressHashCode(String element) {
		int index;
		int hashCode = element.hashCode();
		index = hashCode % table.length;
		return index;
	}

	/**
	 * Node Class that is used for the linked list portion of the hash table
	 * 
	 * @author john1819
	 *
	 */
	private class Node {
		private String data;
		private Node next;

		/**
		 * Constructor for Node forcing user to set data at construction
		 * 
		 * @param data
		 */
		private Node(String data) {
			this.data = data;
			this.next = null;
		}
	}
}
