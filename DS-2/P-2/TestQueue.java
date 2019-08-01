
import static org.junit.Assert.*;

import org.junit.Test;

public class TestQueue {
	private boolean expected1 =  true;
	private boolean expected2 =  true;

	
	
	@Test
	 public void testOp1(){
		QueueOp queue = new QueueOp(5);
		assertEquals(expected1, queue.isEmpty()); 
	}
	
	@Test
	 public void testOp2(){
		QueueOp queue = new QueueOp(5);
		queue.insert(4);
		queue.insert(4);
		queue.insert(4);
		queue.insert(4);
		queue.insert(4);
		assertEquals(expected1, queue.isFull());
	}
	
}
