import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	private static final String[] EXCLUDED_WORDS = { "", "a", "an", "and", "the" };

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

	/**
	 * This toString method outputs all the data related to the WordProcessor in
	 * table format.
	 * 
	 * @return string with all the data in it
	 */
	public String toString() {
		String res = "";
		res += ("The number of unique words in each file\n" + Table1);
		for (File fi : files) {
			try {
				res += String.format("%s\t %d\n", fi.getName(), totalUnique(fi));
			} catch (FileNotFoundException e) {
				// if the file somehow doesn't exist while grabbing the number of unique words
				e.printStackTrace();
			}
		}
		res += ("The 10 most common words in each file\n");
		for (File fi : files) {
			try {
				ArrayList<UniqueWord> temp = mostCommon(fi);
				for (UniqueWord word : temp) {
					int rank = 0;
					res += String.format(Table2 + "\t%d %s\t %d", rank, word.word, word.frequency);
					rank++;
				}
			} catch (FileNotFoundException e) {
				// if the file somehow doesn't exist while grabbing the number of unique words
				e.printStackTrace();
			}
		}
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
			String[] temp = reader.nextLine().split("[^a-zA-Z]+");
			for (String s : temp) {
				s = s.toLowerCase();
				if (!words.contains(s) && !containsEX(s)) {
					words.add(s);
				}
			}
		}
		reader.close();
		res = words.size();
		return res;
	}

	/**
	 * A method which takes all the unique words and keeps track of their individual
	 * frequencies finding the most common ones.
	 * 
	 * @param fi text file
	 * @return the 10 most common words excluding the exceptions
	 * @throws FileNotFoundException if the file doesn't exist
	 */
	public ArrayList<UniqueWord> mostCommon(File fi) throws FileNotFoundException {
		Scanner reader = new Scanner(fi);
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> frequency = new ArrayList<Integer>();
		while (reader.hasNextLine()) {
			String[] temp = reader.nextLine().split("[^a-zA-Z]+");
			for (String s : temp) {
				s = s.toLowerCase();
				if (!words.contains(s) && !containsEX(s)) {
					words.add(s);
					frequency.add(1);
				} else if (!containsEX(s)) {
					frequency.set(words.indexOf(s),  1 + frequency.get(words.indexOf(s)));
				}

			}
		}
		reader.close();
		UniqueWord[] res = new UniqueWord[words.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = new UniqueWord(words.get(i), frequency.get(i));
		}
		
		return null;
	}

	/**
	 * Get method to return the amount of text files inside of the WordProcessor.
	 * 
	 * @return amount of files
	 */
	public int getFileAmt() {
		return files.length;
	}

	/**
	 * Helper method to check and see if a word should be excluded or not.
	 * 
	 * @param ex the word that will be checked
	 * @return true/false
	 */
	private boolean containsEX(String ex) {
		for(String s : EXCLUDED_WORDS) {
			if(s.equals(ex)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Private class to keep track of each words frequency inside of the text file.
	 * 
	 * @author James H
	 *
	 */
	private class UniqueWord {
		private int frequency;
		private String word;

		private UniqueWord(String wordIn, int freq) {
			this.word = wordIn;
			this.frequency = freq;
		}

	}

}
