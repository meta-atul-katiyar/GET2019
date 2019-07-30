
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class LoopTest {
	private boolean expected = true;
	private LinkedList linkedList;
	private LinkedList.Node node;
	 
	 @Test
	 public void testListRotation(){
		LinkedList list = new LinkedList();
		list = linkedList.insert(list, 2);
		list = linkedList.insert(list, 3);
		list = linkedList.insert(list, 4);
		list = linkedList.insert(list, 5);
		list = linkedList.insert(list, 6);
		list = linkedList.insert(list, 7);
		list.end.next = list.start;
		
		assertEquals(expected,list.loopInList(list)); 
	 }
}
