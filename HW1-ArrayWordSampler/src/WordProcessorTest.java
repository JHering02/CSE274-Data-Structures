import static org.junit.Assert.*;

import org.junit.Test;

public class WordProcessorTest {

	@Test
	public void testToString() {
		long start = System.currentTimeMillis();
		WordProcessor test = new WordProcessor("C:\\Users\\james\\git\\CSE274\\HW1-ArrayWordSampler\\textFiles");
		System.out.println(test.toString());
		System.out.println("Time Taken : " + (System.currentTimeMillis() - start) + " ms");
	}

	public void testGetters() {
		WordProcessor test = new WordProcessor("C:\\Users\\james\\git\\CSE274\\HW1-ArrayWordSampler\\textFiles");
		assertEquals((test.getFileAmt()), 3);
	}

}
