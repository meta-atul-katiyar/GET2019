import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	Connection connection = null;
	PreparedStatement ps = null;

	/**
	 * @return Connection type object
	 */
	public PreparedStatement estabConn(String query) {
		
		try {
			Properties properties = new Properties();
		
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));

			String url = properties.getProperty("jdbc.url");
			String driver = properties.getProperty("jdbc.driver");
			String username = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");
		
			Class.forName(driver).newInstance();
		
			connection = DriverManager.getConnection(url, username, password);
			ps = connection.prepareStatement(query);
			
			return ps;
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("error in loading drivers" + cnfe);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(){
		try {
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
