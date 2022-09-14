import java.util.Scanner;

/**
 * A Class to check whether or not a String value is a palindrome (a word that
 * can be the same reversed).
 * 
 * @author James Hering, CSE 274, 14 September 2022
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		String input = "";
		// Inputting a String
		Scanner reader = new Scanner(System.in);
		System.out.printf("Please input the string: \n");
		// Setting the String to the input variable
		input = reader.nextLine();
		// Using a reverse iteration method to reverse the String
		String rev = reverse(input);
		// Checking if the reversed string is equal to the initial
		if (rev.equals(input)) {
			System.out.print("The given string is a palindrome.");
		} else {
			System.out.println("The given string isn't a palindrome.");
		}
		// Close the Scanner
		reader.close();

	}

	public static String reverse(String in) {
		String res = "";
		// Starts at the end of the index of input and adds chars reversely
		for (int i = in.length() - 1; i >= 0; i--) {
			res += in.charAt(i);
		}
		// return reversed String
		return res;
	}
}
