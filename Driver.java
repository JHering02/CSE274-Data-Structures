import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		// Do your own testing here.  Create a WordList object,
		// add, remove, check what's in th array, and so on.
		// Test edge cases as you go.
		WordList w1 = new WordList(15);
		WordList w2 = new WordList();
		System.out.println(w1.size());
		System.out.println(w2.size());
		w1.add("Yippie");
		System.out.println(w1.get(w1.size()));
		
		
		
		

	}
	


}
