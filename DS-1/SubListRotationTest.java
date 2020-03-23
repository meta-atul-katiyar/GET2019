
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class SubListRotationTest {
	private int[] expected = new int[]{4, 5, 6, 7, 2, 3};
	private LinkedList linkedList;
	private Node node;
	 
	 @Test
	 public void testListRotation(){
		LinkedList list = new LinkedList();
		list = linkedList.insert(list, 2);
		list = linkedList.insert(list, 3);
		list = linkedList.insert(list, 4);
		list = linkedList.insert(list, 5);
		list = linkedList.insert(list, 6);
		list = linkedList.insert(list, 7);
		
		list = linkedList.clockwiseRotation(list, 1, 6, 4);
		int[] ans = new int[6];
		node = list.start;
		System.out.println("linked list:");
		int index =0;
		while(node != null){
			ans[index++] = node.data;
			node = node.next;
		}
		assertArrayEquals(expected,ans); 
	 }
}
