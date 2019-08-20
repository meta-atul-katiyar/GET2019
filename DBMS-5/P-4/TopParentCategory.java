import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TopParentCategory {

	/**
	 * print top parent name their sub category count
	 */
	public void topParent() {
		PreparedStatement ps = null;
		ResultSet rSet = null;
		DBConnection dbConn = new DBConnection("storefront");
		String query = "SELECT C.categoryName, count(C.categoryId) FROM category AS P "
				+ "INNER JOIN category AS C ON P.parentCategoryId = C.categoryId "
				+ "WHERE C.parentCategoryId is NULL GROUP BY P.parentCategoryId ORDER BY C.categoryName ";

		Connection connection = dbConn.estabConn();

		try {
			connection = dbConn.estabConn();
			ps = connection.prepareStatement(query);
			rSet = ps.executeQuery();
			while (rSet.next())
				System.out.println(rSet.getString(1) + " " + rSet.getString(2)
						+ " ");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rSet.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		TopParentCategory dop = new TopParentCategory();
		dop.topParent();
	}
}
