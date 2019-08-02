
import static org.junit.Assert.*;

import org.junit.Test;

public class TestQueue {
	private int[] expected1 =  new int[]{8,9};

	
	@Test
	 public void testOp2(){
		PriorityQueueImplement pQueue = new PriorityQueueImplement(5);
		pQueue.insert(new int[]{4,3});
		pQueue.insert(new int[]{5,6});
		pQueue.insert(new int[]{6,1});
		pQueue.insert(new int[]{7,2});
		pQueue.insert(new int[]{8,9});
		
		assertArrayEquals(expected1, pQueue.delete());
	}
	
}
