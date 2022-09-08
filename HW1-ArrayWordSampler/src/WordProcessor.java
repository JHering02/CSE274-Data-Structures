import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A java class with the sole job of processing Google Trends text into readable
 * info
 * 
 * @author James Hering, CSE 274, 7 September 2022
 *
 */
public class WordProcessor {
	private static final String Table1 = "File\tNum unique words\t\n========== ==========\n";
	private static final String Table2 = "%s\n\tRank Word\t Frequency\n\t==== ====\t=========\n";
	private String folderName;
	private File folder;
	private File[] files;

	/**
	 * Default parameter constructor for a WordProcessor, that gives it all the info
	 * to start analyzing the words.
	 * 
	 * @param name
	 */
	public WordProcessor(String name) {
		this.folderName = name;
		this.folder = new File(name);
		this.files = folder.listFiles();
	}

	public String toString() {
		String res = "";
		return res;
	}

	/**
	 * Runs through a file, and finds the total amount of unique words contained
	 * within that file. Has O(n^2) time complexity.
	 * 
	 * @param fi text file
	 * @return integer with the total amount of unique words
	 * @throws FileNotFoundException if the file does not exist
	 */
	public int totalUnique(File fi) throws FileNotFoundException {
		int res = 0;
		Scanner reader = new Scanner(fi);
		ArrayList<String> words = new ArrayList<String>();
		while (reader.hasNextLine()) {
			String[] temp = reader.nextLine().split(" ");
			for (String s : temp) {
				if (!words.contains(s)) {
					words.add(s);
				}
			}
		}
		reader.close();
		return res;
	}
}
