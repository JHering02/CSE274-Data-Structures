import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	
	QueueInterface<Integer> queue;
	QueueInterface<Integer> queue2;
	
	@Before
	public void createQueue() {
		queue = new ArrayQueue<>(); // change to LinkedQueue when you are ready
		queue2 = new LinkedQueue<>();
	}

	@Test
	public void testIsEmpty() {
		// Array Queue
		assertTrue(queue.isEmpty());
		queue.add(10);
		assertFalse(queue.isEmpty());
		
		// LinkedQueue
		assertTrue(queue2.isEmpty());
		queue.add(10);
		assertFalse(queue2.isEmpty());
	}
	
	@Test
	public void testpeek() {
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.add(n);
			queue2.add(n);
			assertEquals(47, (int)queue.peek());
			assertEquals(47, (int)queue2.peek());
		}
	
	}
	
	@Test
	public void testQueueing() {
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.add(n);
			queue2.add(n);
			// Array Queue
			assertFalse(queue.isEmpty());
			assertEquals(n, (int)queue.remove());
			assertTrue(queue.isEmpty());
			// Linked Queue
			assertFalse(queue2.isEmpty());
			assertEquals(n, (int)queue2.remove());
			assertTrue(queue2.isEmpty());
		}		
		
		for (int n : data) {
			queue.add(n);
			queue.add(n);
			queue2.add(n);
			queue2.add(n);
		}
		queue.remove();
		queue.remove();
		queue2.remove();
		queue2.remove();
		for (int n : data) {
			queue.add(n);
			queue2.add(n);
		}
		
		for (int i = 2; i < data.length; i++) {
			assertEquals(data[i], (int)queue.remove());
			assertEquals(data[i], (int)queue2.remove());
		}
		for (int n : data) {
			assertEquals(n, (int)queue.remove());
			assertEquals(n, (int)queue2.remove());
		}		

		while(!queue.isEmpty()) {
			queue.remove();
		}		
		
		assertTrue(queue.isEmpty());		
		
	}
}
