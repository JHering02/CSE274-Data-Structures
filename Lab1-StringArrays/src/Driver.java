import java.util.Arrays;

/**
 * This is a test class for the WordList 
 * 
 * @author James Hering, CSE 271, 1 February 2022
 */
public class Driver {

	/** 
	 * Main Method for testing
	 * @param args main java arguments
	 */
	public static void main(String[] args) {

		// Do your own testing here. Create a WordList object,
		// add, remove, check what's in th array, and so on.
		// Test edge cases as you go
		
		//Testing Constructors
		WordList w1 = new WordList(15);
		WordList w2 = new WordList();
		System.out.println(w1.size());
		System.out.println(w2.size());
		System.out.println();
		
		//Testing the ability to add words to the list
		w1.add("Yippie");
		System.out.println(w1.get(w1.size() - 1));
		System.out.println(w1.size());
		w2.add(5, "Yes sire");
		System.out.println(w2.get(5));
		System.out.println(w2.size());
		System.out.println();
		
		//Testing the Remove method
		w1.remove(15);
		System.out.println(w1.get(14));
		w2.remove("Yes sire");
		System.out.println(w2.get(5));
	}

}
