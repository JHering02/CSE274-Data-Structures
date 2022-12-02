import java.util.Stack;

/**
 * This is the infix class which has various functions to interact with an
 * infix.
 * 
 * @author James Hering (CSE 274, 21 October 2022)
 *
 */
public class Infix {

	private String infix;

	/**
	 * Constructs a new Infix object from a given infix expression.
	 * 
	 * @param str infix parameter
	 */
	public Infix(String str) {
		this.infix = clean(str);
	}

	/**
	 * Returns the infix expression.
	 */
	public String toString() {
		return infix;
	}

	/**
	 * Returns true if the infix expression has balanced parentheses, and false
	 * otherwise.
	 * 
	 * @return whether or not infix is balanced
	 */
	public boolean parenBalanced() {
		int open = 0, closed = 0;
		char[] chars = infix.toCharArray();
		for (char ch : chars) {
			if (ch == '(') {
				open++;
			} else if (ch == ')') {
				closed++;
			}
		}
		if (open == closed) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the trimmed, space-delimited postfix expression that corresponds to
	 * the given infix expression.
	 * 
	 * @return a postfix expression
	 */
	public String toPostfix() {
		Stack<Character> order = new Stack<Character>();
		String ops = "+-*/()[]^";
		String res = "";
		for (int i = 0; i < infix.length(); i++) {
			if (ops.indexOf(infix.charAt(i)) == -1 && infix.charAt(i) != Character.MIN_VALUE) {
				res += infix.charAt(i) + " ";
			} else if ((infix.charAt(i) == '(') || (infix.charAt(i) == '[')) {
				order.push(infix.charAt(i));
			} else if ((infix.charAt(i) == ')') || (infix.charAt(i) == ']')) {
				while (!order.empty() && !((order.peek() == '(') || (order.peek() == '['))) {
					res += order.pop();
				}
				order.pop();
			} else if (ops.indexOf(infix.charAt(i)) != -1) {
				while (!order.empty() && (higherPrecedence(infix.charAt(i), order.peek()))
						&& !((order.peek() == '(') || (order.peek() == '['))) {
					res += order.pop();
				}
				order.push(infix.charAt(i));
			}
		}
		while (!order.empty()) {
			if (!((order.peek() == '(') || (order.peek() == '('))) {
				res += (" " + order.pop() + " ");
			} else {
				order.pop();
			}
		}
		res = clean(res);
		return res;
	}

	/**
	 * This method evaluates the expression.
	 * 
	 * @return the integer result of a calculation
	 */
	public int compute() {
		int res = 0;
		Stack<Integer> order = new Stack<Integer>();
		String temp = toPostfix();
		temp = temp.replace(" ", "");
		for (int i = 0; i < temp.length(); i++) {
			char ch = temp.charAt(i);
			if (ch >= '0' && ch <= '9') {
				order.push((int) (ch - '0'));
			} else {
				int num1 = order.pop();
				int num2 = order.pop();
				switch (ch) {
				case '+':
					res = (num1 + num2);
					break;
				case '-':
					res = (num2 - num1);
					break;
				case '*':
					res = (num1 * num2);
					break;
				case '/':
					res = (num2 / num1);
					break;
				default:
					break;
				}
				order.push(res);
			}
		}
		return res;
	}

	/**
	 * Uses basic order of operations to check precidence of two operators.
	 * 
	 * @param ch1 first character
	 * @param ch2 second character
	 * @return
	 */
	private boolean higherPrecedence(char ch1, char ch2) {
		return (returnPrecedence(ch1) >= returnPrecedence(ch2));
	}

	/**
	 * Returns the priority level of a character based on its precedence.
	 * 
	 * @param ch
	 * @return int resembling priority level
	 */
	private int returnPrecedence(char ch) {
		String p1 = "[]()";
		char p2 = '^';
		String p3 = "*/";
		String p4 = "+-";
		if (p1.indexOf(ch) != -1) {
			return 1;
		} else if (p2 == ch) {
			return 2;
		} else if (p3.indexOf(ch) != -1) {
			return 3;
		} else if (p4.indexOf(ch) != -1) {
			return 4;
		}
		return -1;
	}

	/**
	 * cleans the infix expression by putting single spaces between numbers,
	 * operators, // and parentheses. For example: // Changes this: "(3+4)" into
	 * this: "( 3 + 4 )" // Changes this: " ( 3 + 4 ) " into this: "( 3 + 4 )"
	 */
	private String clean(String str) {
		char[] ops = "+-*/()[]^".toCharArray();

		for (char c : ops) {
			str = str.replace("" + c, " " + c + " ");
		}

		str = str.replaceAll("\\s+", " "); // replace all white spaces with a single space
		str = str.trim();
		return str;
	}
}
