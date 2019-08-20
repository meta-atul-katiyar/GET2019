
import static org.junit.Assert.*;

import org.junit.Test;


public class TestOrderByUID {
	private String[][] expected = new String[][] {
			{"3", "30.0", "2019-08-15 23:35:48"},
			{"7", "150.0", "2019-08-15 23:35:48"}
			};
	 
	 @Test
	 public void testorder() {
		 
		 OrderByUID obuid = new OrderByUID("7");
		 obuid.orderDetail();
		 String[][] actual = new String[obuid.orders.size()][3];
		 int index=0;
		 for(OrdersInShippedState oiss : obuid.orders){
			 
			actual[index][0] = oiss.getOrder_id();
			actual[index][1] = oiss.getOrder_amount();
			actual[index][2] = oiss.getOrder_date();
			index+=1;
		 }
	     assertArrayEquals(expected, actual);
	   } 
}
