
import java.sql.SQLException;
import java.sql.ResultSet;

public class TopParentCategory {

	/**
	 * print top parent name their sub category count
	 */
	public void topParent() {
		ResultSet rSet = null;
		DBConnection dbConn = new DBConnection("storefront");
		Query queryObj = new Query();
		String query = queryObj.getCategoryQuery();

		try {
			rSet = dbConn.estabConn(query).executeQuery();
			while (rSet.next())
				System.out.println(rSet.getString(1) + " " + rSet.getString(2)
						+ " ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TopParentCategory dop = new TopParentCategory();
		dop.topParent();
	}
}
