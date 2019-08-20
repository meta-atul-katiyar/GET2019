
import java.sql.SQLException;
public class DeleteOldProducts {

	/**
	 * delete products that are not ordered past 1 year
	 */
	public void deleteProduct() {
		DBConnection dbConn = new DBConnection("storefront");
		Query queryObj = new Query();
		String query = queryObj.getDeleteQuery();

		try {
			System.out.println(dbConn.estabConn(query).executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DeleteOldProducts dop = new DeleteOldProducts();
		dop.deleteProduct();
	}
}
