
/**
 * This is a binary expression tree. It is initialized with a postfix string and
 * can be printed out as either the postfix expression or the infix expression.
 * It does
 * 
 * @author john1819
 *
 */
public class BET {

	private BinaryNode root;
	private String postfix;

	/**
	 * Default constructor - creates an empty tree
	 */
	public BET() {
		// creates an empty Tree
	}

	/**
	 * Constructor accepting postfix string to parse
	 * 
	 * @param pf - the postfix string
	 */
	public BET(String pf) {
		// builds tree based on input postfix string
		postfix = pf;
		buildFromPostfix(postfix);
	}

	/**
	 * Method accepts input string and builds the tree based on it
	 * 
	 * @param pf - the postfix string
	 * @return - true if tree build, false if bad pf format
	 */
	public boolean buildFromPostfix(String pf) {
		return false;
	}

	/**
	 * Method that prints an infix expression from the BET. If tree is empty, prints
	 * "No expression available"
	 */
	public void printInfixExpression() {

	}

	/**
	 * Method that prints postfix expression used to build BET. If tree is empty,
	 * prints "No expression available"
	 */
	public void printPostfixExpression() {

	}

	/**
	 * Outputs number of nodes in the tree
	 * 
	 * @return int
	 */
	public int size() {
		return 0;
	}

	/**
	 * isEmpty() - returns true if empty, false if not
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return true;
	}

	/**
	 * BinaryNode class- class representing a node in the BET. Not accessible
	 * outside this class
	 * 
	 * @author john1819
	 *
	 */
	private class BinaryNode {
		String element;
		BinaryNode right;
		BinaryNode left;

		/**
		 * Constructor to create node with known data
		 * 
		 * @param String - data to be stored
		 */
		public BinaryNode(String element) {
			this.element = element;
			right = null;
			left = null;
		}

	}

}
