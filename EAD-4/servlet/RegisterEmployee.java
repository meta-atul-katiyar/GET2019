
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet Name 
@WebServlet("/InsertEmployeeData")
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			DBConnection dbConn = new DBConnection();
					//dbConn1 = new DBConnection();
			int empId=-1;
			String email = request.getParameter("email");
			String query = "INSERT INTO `EAD-4`.`employee_detail`"
					+ " (fullName, gender, email, password, contactNumber, organization)"
					+ " values(?, ?, ?, ?, ?, ?)",
					queryId = "SELECT * FROM `EAD-4`.`employee_detail` AS ED"
						+" WHERE ED.email=\""+email+"\";";
			PreparedStatement st = dbConn.estabConn(query);
			
			st.setString(1, request.getParameter("fullName"));
			st.setString(2, request.getParameter("gender"));
			st.setString(3, email);
			st.setString(4, request.getParameter("password"));
			st.setInt(5, Integer.parseInt(request.getParameter("contactNumber")));
			st.setString(6, request.getParameter("organization"));

			
			try{
				// Execute the insert command using executeUpdate()
				// to make changes in database
				st.executeUpdate();
				
				// get empId
				ResultSet rs = st.executeQuery(queryId);
				rs.next();
				empId = rs.getInt(1);

				// Close all the connections
				st.close();
				dbConn.closeConnection();
				// Get a writer pointer
				// to display the successful result
				PrintWriter out = response.getWriter();
				out.println("<b>Successfully Inserted"
						+ "</b>");
				RequestDispatcher rd = request.getRequestDispatcher("VehicleForm?empId="+empId); 
				rd.forward(request, response); 
			} catch(java.sql.SQLIntegrityConstraintViolationException e){
				PrintWriter out = response.getWriter();
				out.println("<html><body><b>email already exists"
						+ "</b><br/><br/></body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}