
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class BatchImageInsert {

	int productId;	
	PreparedStatement ps = null;
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
		DBConnection dbConn = new DBConnection("storefront");
		Query queryObj = new Query();
		String query = queryObj.getInsertQuery();

		try {
			ps = dbConn.estabConn(query);
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
		} finally{
			try {
				ps.close();
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
