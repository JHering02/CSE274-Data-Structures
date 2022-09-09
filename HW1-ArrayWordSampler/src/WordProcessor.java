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
				UniqueWord[] temp = totalUnique(fi);
				res += String.format("%s\t %d\n", fi.getName(), temp.length);
			} catch (FileNotFoundException e) {
				// if the file somehow doesn't exist while grabbing the number of unique words
				e.printStackTrace();
			}
		}
		res += ("The 10 most common words in each file\n");
		for (File fi : files) {
			try {
				UniqueWord[] temp = totalUnique(fi);
				temp = tenCommon(temp, temp.length);
				int rank = 1;
				res += String.format(Table2, fi.getName());
				for (int i = 0; i < 10; i++) {
					res += String.format("\t%d %s\t%d\n", rank, temp[i].word, temp[i].frequency);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * Runs through a file, and finds all unique words with their frequencies inside
	 * of a text file. Has O(n^2) time complexity worst case.
	 * 
	 * @param fi text file
	 * @return integer with the total amount of unique words
	 * @throws FileNotFoundException if the file does not exist
	 */
	public UniqueWord[] totalUnique(File fi) throws FileNotFoundException {
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
					int fr = frequency.get(words.indexOf(s));
					frequency.set(words.indexOf(s), fr + 1);
				}
			}
		}
		UniqueWord[] res = new UniqueWord[words.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = new UniqueWord(words.get(i), frequency.get(i));
		}
		reader.close();
		return res;
	}

	/**
	 * Helper method that recursively sorts a complete list of UniqueWords and
	 * returns the 10 most frequent ones. Has O(n^2) time complexity worst case.
	 * 
	 * @param words inital word list
	 * @return copyOf the initial list with only the 10 most frequent
	 */
	public UniqueWord[] tenCommon(UniqueWord[] words, int cur) {
		if (cur == 1) {
			return Arrays.copyOfRange(words, words.length - 11, words.length - 1);
		}
		for (int i = 0; i < cur - 1; i++) {
			if (words[i].frequency > words[i + 1].frequency) {
				UniqueWord temp = words[i];
				words[i] = words[i + 1];
				words[i + 1] = temp;
			}
		}
		return tenCommon(words, cur - 1);
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
	 * Helper method to check and see if a word should be excluded or not. Has
	 * O(logn) time complexity worst case.
	 * 
	 * @param ex the word that will be checked
	 * @return true/false
	 */
	private boolean containsEX(String ex) {
		int max = EXCLUDED_WORDS.length - 1;
		int min = 0;
		while (!(max < min)) {
			int mid = (max + min) / 2;
			if (ex.equals(EXCLUDED_WORDS[mid])) {
				return true;
			} else if (ex.compareTo(EXCLUDED_WORDS[mid]) > 0) {
				min = mid + 1;
			} else {
				max = mid - 1;
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
		private int frequency = 0;
		private String word = "";

		private UniqueWord(String wordIn, int freq) {
			this.word = wordIn;
			this.frequency = freq;
		}

	}

}
