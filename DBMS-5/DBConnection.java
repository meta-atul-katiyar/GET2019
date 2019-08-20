import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	String dbName;
	String host;
	String mysqlURL;
	String userId;
	String password;

	/**
	 * @param db
	 * CREATE URL FOR GIVEN DB NAME
	 */
	DBConnection(String db) {
		this.dbName = db;
		host = "jdbc:mysql://localhost:3306/";
		mysqlURL = host + dbName
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&"
				+ "useLegacyDatetimeCode=false&serverTimezone=UTC";
		userId = "root";
		password = "root";
	}

	/**
	 * @return Connection type object
	 */
	public Connection estabConn() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("error in loading drivers" + cnfe);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager
					.getConnection(mysqlURL, userId, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
