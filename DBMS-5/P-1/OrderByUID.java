import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		Statement stmt = null;
		ResultSet rSet = null;
		DBConnection dbConn = new DBConnection("storefront");
		
		Connection connection = null;
		
		try {
			connection = dbConn.estabConn();
			String query = "SELECT SO.shopperorderId, SO.timestamp, SO.totalamount "
					+ "FROM shopperorder AS SO NATURAL JOIN orderdetail AS OD WHERE "
					+ "SO.userId = "+ shopperId +" AND OD.status = 'shipped' AND "
					+ "SO.shopperorderId NOT IN (SELECT so.shopperorderId FROM shopperorder AS so NATURAL JOIN "
					+ "orderdetail AS od WHERE od.status <> 'shipped')  ";

			stmt = connection.createStatement();
			
			rSet = stmt.executeQuery(query);
			while (rSet.next())
				orders.add(new OrdersInShippedState(rSet.getString(1), rSet.getString(2), rSet.getString(3)));
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
		   try { 
			connection.close();
		   }
		   catch (SQLException e){
			   e.printStackTrace();
		   }
		}
	}

	public static void main(String[] args) {
		OrderByUID obuid = new OrderByUID("7");
		obuid.orderDetail(); 

	}
}
