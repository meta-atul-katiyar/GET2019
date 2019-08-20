
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class OrderByUID {
	String shopperId;
	LinkedList<OrdersInShippedState> orders = new LinkedList<OrdersInShippedState>();
	
	/**
	 * @param id
	 * INDERT USER ID OF THE SHOPPER
	 */
	OrderByUID(String id){
		shopperId = id;
	}

	/**
	 * PRINT ORDER DETAIL WHICH ARE NOT SHIPPED
	 */
	public void orderDetail() {
		ResultSet rSet = null;
		DBConnection dbConn = new DBConnection("storefront");
		
		try {
			
			Query queryObj = new Query();
			String query = queryObj.getQuery(this.shopperId);
			
			rSet = dbConn.estabConn(query).executeQuery(query);
			while (rSet.next())
				orders.add(new OrdersInShippedState(rSet.getString(1), rSet.getString(2), rSet.getString(3)));
			
			dbConn.closeConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		OrderByUID obuid = new OrderByUID("7");
		obuid.orderDetail(); 

	}
}
