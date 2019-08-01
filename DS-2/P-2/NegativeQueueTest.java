
import static org.junit.Assert.*;
import org.junit.Test;

public class NegativeQueueTest {
	private boolean expected1 =  false;

	
	@Test
	 public void testOp2(){
		QueueOp queue = new QueueOp(5);
		queue.insert(4);
		queue.insert(4);
		queue.insert(4);
		queue.insert(4);
		queue.delete();
		queue.insert(4);
		assertEquals(expected1, queue.isFull());
	}
	
}
