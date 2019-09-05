package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	/**function to Authenticate user
	 * @param email
	 * @param password
	 * @return
	 */
	public static boolean authenticateUser(String email, String password) {
		boolean status = false;
		try {
			System.out.println("inside authenticate user ");
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from mvc2.user where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}


	/**function to get the userId from the email
	 * @param email
	 * @return
	 */
	public static int getUserId(String email) {
		try {
			System.out.println("inside getUserId ");
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select userId from mvc2.user where email=?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			rs.next();
			
			return rs.getInt("userId");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
}
