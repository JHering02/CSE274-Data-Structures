public class InfixPostfixHelper {

	private String infix;

	// cleans the infix expression by putting single spaces between numbers, operators,
	// and parentheses.  For example:
	// Changes this: "(3+4)" into this: "( 3 + 4 )"
	// Changes this: "    (   3   +   4   )   " into this: "( 3 + 4 )"
	private void clean() {
		char[] ops = "+-*/()[]^".toCharArray();

		for (char c : ops) {
			infix = infix.replace("" + c, " " + c + " ");
		}

		infix = infix.replaceAll("\\s+"," "); // replace all white spaces with a single space
		infix = infix.trim();
	}


	// returns true if the given string represents an int,
	// and false otherwise
	private boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}



	public static void main(String args[]) {

		InfixPostfixHelper iph = new InfixPostfixHelper();
		iph.infix = " ((1 + [13			-		554]))*500          - 0";
		iph.clean();

		System.out.println(iph.infix);

		// When parts of a string are separated by single spaces, split works very well
		// for converting that expression into an array.
		String[] arr = iph.infix.split(" ");

		for(int i = 0; i < arr.length; i++) {
			if(iph.isNumber(arr[i])) {
				System.out.println("Number " + arr[i]);
			}else {
				System.out.println("Operation " + arr[i]);
			}
		}
	}
}