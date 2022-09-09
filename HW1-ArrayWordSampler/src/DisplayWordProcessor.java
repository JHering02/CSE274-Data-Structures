import java.util.Scanner;

/**
 * A java class to display a word processor.
 * 
 * @author James H, CSE274, 9 September 2022
 *
 */
public class DisplayWordProcessor {

	/**
	 * Method to ask the user where the filepath they want words displayed is.
	 * 
	 * @param args normal arguments
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the directory you wish to display.");
		WordProcessor wp = new WordProcessor(reader.next());
		System.out.printf(wp.toString());

	}

}
