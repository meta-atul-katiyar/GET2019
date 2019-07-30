
import static org.junit.Assert.*;
import org.junit.Test;

public class NegativeLinkedListTest {
	private LinkedList linkedList;
	private Node node;
	
	 @Test (expected = java.lang.NullPointerException.class)
	 public void testList(){
		 LinkedList list = new LinkedList();
		 list.clockwiseRotation(list, 1, 6, 4);
	 }
}
