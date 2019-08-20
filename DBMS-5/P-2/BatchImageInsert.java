import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class BatchImageInsert {

	int productId;

	/**
	 * @param numId
	 * INSERT PRODUCT ID
	 */
	BatchImageInsert(int numId) {
		productId = numId;
	}

	/**
	 * @param productId
	 * INSERT IMAGES OF SPECIFIED PRODUCT BY BATCH TECHNIQUE
	 */
	public void batchInsert(int productId) {
		PreparedStatement ps = null;
		DBConnection dbConn = new DBConnection("storefront");
		String query = "INSERT INTO `storefront`.`productimage` "
				+ "(`imageName`, `productId`) VALUES (?, ?);";
		Connection connection = dbConn.estabConn();
		;

		try {
			connection = dbConn.estabConn();
			ps = connection.prepareStatement(query);
			int size = 9, row = 0;

			for (row = 0; row < size; row++) {
				ps.setString(1, "Name" + row);
				ps.setInt(2, productId);

				ps.addBatch();

				if (row % 5 == 0)
					ps.executeBatch();
			}
			ps.executeBatch();
			System.out.println(row + " rows added");

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
		BatchImageInsert bii = new BatchImageInsert(20101);
		bii.batchInsert(bii.productId);

	}
}
