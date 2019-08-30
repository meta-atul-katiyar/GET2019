import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet Name 
@WebServlet("/InsertData")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			DBConnection dbConn = new DBConnection("EAD-3");
			// Create a SQL query to insert data into demo table
			// demo table consists of two columns, so two '?' is used
			String query = "insert into `EAD-3`.`student_information`"
					+ " (firstName, lastName, fatherName, email, class, age)"
					+ " values(?, ?, ?, ?, ?, ?)";
			PreparedStatement st = dbConn.estabConn(query);
			
			st.setString(1, request.getParameter("firstName"));
			st.setString(2, request.getParameter("lastName"));
			st.setString(3, request.getParameter("fatherName"));
			st.setString(4, request.getParameter("email"));
			st.setInt(5, Integer.parseInt(request.getParameter("class")));
			st.setInt(6, Integer.parseInt(request.getParameter("age")));

			// Execute the insert command using executeUpdate()
			// to make changes in database
			st.executeUpdate();

			// Close all the connections
			st.close();
			dbConn.closeConnection();
			// Get a writer pointer
			// to display the successful result
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Inserted"
					+ "</b></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}