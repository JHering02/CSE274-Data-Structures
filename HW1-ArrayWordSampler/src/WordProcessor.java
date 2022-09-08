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
	private String currFile;
	private int currIndex = 0;
	private Scanner process;
	
	
	public WordProcessor(String fileName) throws FileNotFoundException {
		this.process = new Scanner(new File(fileName));
		this.currFile = fileName;
	}
	
	
}
