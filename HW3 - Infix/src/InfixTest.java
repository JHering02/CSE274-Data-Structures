import static org.junit.Assert.*;

import org.junit.Test;

public class InfixTest {

	@Test
	public void testInfix() {
		Infix test = new Infix("(1 + 2) + (3 + 4)    ");
		Infix test2 = new Infix("         (1+2) + (3 + 4)");
		assertEquals(test.toString(), test2.toString());
	}

	@Test
	public void testToString() {
		Infix test = new Infix("(1 * 2) * 3");
		assertEquals("( 1 * 2 ) * 3", test.toString());
	}

	@Test
	public void testParenBalanced() {
		Infix nonBalanced = new Infix("(((4)");
		assertFalse(nonBalanced.parenBalanced());
	}

	@Test
	public void testToPostfix() {
		Infix test = new Infix("1 + 2 + 3 + 4");
		assertEquals("1 2 + 3 + 4 +", test.toPostfix());
		Infix test2 = new Infix("(1 + 2) + (3 + 4)");
		assertEquals("1 2 + 3 4 + +", test2.toPostfix());
		Infix test3 = new Infix("1 * ( 2 + 3 )");
		assertEquals("1 2 3 + *", test3.toPostfix());
		Infix test4 = new Infix("1 + 2 * 3 - 4 * 5");
		assertEquals("1 2 3 * + 4 5 * -", test4.toPostfix());
	}

	@Test
	public void testCompute() {
		Infix test = new Infix("1 + 2 + 3 + 4");
		assertEquals(10, test.compute());
		Infix test2 = new Infix("(1 + 2) + (3 + 4)");
		assertEquals(10, test2.compute());
		Infix test3 = new Infix("1 * ( 2 + 3 )");
		assertEquals(5, test3.compute());
		Infix test4 = new Infix("1 + 2 * 3 / 4 * 5");
		assertEquals(6, test4.compute());
	}

}
