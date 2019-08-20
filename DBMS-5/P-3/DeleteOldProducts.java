import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DeleteOldProducts {

	/**
	 * delete products that are not ordered past 1 year
	 */
	public void deleteProduct() {
		PreparedStatement ps = null;
		DBConnection dbConn = new DBConnection("storefront");
		String query = "UPDATE product AS P  SET status = 0 WHERE P.productId NOT IN "
				+ " (SELECT od.productId FROM orderdetail AS od NATURAL JOIN shopperorder AS so "
				+ "WHERE so.timestamp > now() - INTERVAL 1 YEAR) AND P.productId >0";
		Connection connection = dbConn.estabConn();
		;

		try {
			connection = dbConn.estabConn();
			ps = connection.prepareStatement(query);
			System.out.println(ps.executeUpdate());
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		DeleteOldProducts dop = new DeleteOldProducts();
		dop.deleteProduct();
	}
}
