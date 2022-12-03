import java.util.Stack;

/**
 * This is a binary expression tree. It is initialized with a postfix string and
 * can be printed out as either the postfix expression or the infix expression.
 * It does
 * 
 * @author john1819, James Hering
 *
 *         2 December 2022
 */
public class BET {

	private BinaryNode root;
	private String postfix;
	private final String OPS = "+-*/^";
	private int size = 0;

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
		// Check if the postfix is valid
		if (!OPS.contains(pf.substring(pf.length() - 1))) {
			return false;
		} else if (pf.contains("(") || pf.contains(")")) {
			return false;
		} else if (pf.contains("[") || pf.contains("]")) {
			return false;
		}
		// Make a new root if there was one already, and Re-assign postfix
		root = null;
		postfix = pf;
		String[] post = postfix.split(" ");
		Stack<BinaryNode> order = new Stack<BinaryNode>();
		// Iterate through an array of each postfix character
		for (String ch : post) {
			if (!OPS.contains(ch)) {
				order.push(new BinaryNode(ch)); // Push operand to stack
				size++; // Add a node to size
			} else {
				// If operator, pop both stack operands & mk new Node
				BinaryNode exp1 = order.pop();
				BinaryNode exp2 = order.pop();
				BinaryNode res = new BinaryNode(ch);
				res.left = exp1;
				res.right = exp2;
				order.push(res);
				size++; // Still adding a node here, just an operator
			}
		}
		root = order.pop(); // Allocate the new built tree using stack
		if (!order.isEmpty()) {
			// If the stack isn't empty, what do we do?
			BinaryNode res = new BinaryNode(post[post.length - 1]);
			res.left = order.pop();
			res.right = root;
			root = res;
			size++;
		}
		return true;
	}

	/**
	 * Method that prints an infix expression from the BET. If tree is empty, prints
	 * "No expression available"
	 */
	public void printInfixExpression() {
		// Check for an empty tree 1st then call recursive infix
		if (root == null) {
			System.out.println("No expression available");
			return;
		}
		Stack<String> order = new Stack<String>();
		printInfix(order, postfix.split(" "), 0);
	}

	/**
	 * Private recursive helper method that is meant for printInfixExpression().
	 */
	private void printInfix(Stack<String> order, String[] post, int index) {
		if (index < post.length) { // This is our recursive condition
			if (!OPS.contains(post[index])) {
				order.push(post[index]); // Push Operands
				printInfix(order, post, index + 1);
			} else {
				String ch1 = order.pop();
				String ch2 = order.pop();
				String res = String.format("( %s %s %s )", ch2, post[index], ch1);
				order.push(res); // Push formatted infix expression to the stack
				printInfix(order, post, index + 1);
			}
		}
		if (index == 0) {
			String str = order.pop();
			if (!order.isEmpty()) {
				String ch2 = order.pop();
				String res = String.format("%s %s %s", ch2, post[post.length - 1], str);
				order.push(res); // Push formatted infix expression to the stack
				str = order.pop();
			}
			System.out.println(str);
		}
	}

	/**
	 * Method that prints postfix expression used to build BET. If tree is empty,
	 * prints "No expression available"
	 */
	public void printPostfixExpression() {
		if (root == null) {
			System.out.println("No expression available");
		} else {
			System.out.println(postfix);
		}
	}

	/**
	 * Outputs number of nodes in the tree
	 * 
	 * @return int
	 */
	public int size() {
		return size;
	}

	/**
	 * isEmpty() - returns true if empty, false if not
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return size == 0;
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
