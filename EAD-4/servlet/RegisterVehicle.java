
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Servlet Name 
@WebServlet("/InsertVehicleData")
public class RegisterVehicle extends HttpServlet {
	
	String defaultCurrency = "USD";
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			DBConnection dbConn = new DBConnection();
			
			String query = "INSERT INTO `EAD-4`.`vehicle_detail`"
					+ " (vehicleName, type, vehicleNumber, employeeId, identification)"
					+ " values(?, ?, ?, ?, ?)";
			PreparedStatement st = dbConn.estabConn(query);
			
			st.setString(1, request.getParameter("vehicleName"));
			st.setString(2, request.getParameter("vehicleType"));
			st.setString(3, request.getParameter("vehicleNumber"));
			st.setInt(4, Integer.parseInt(request.getParameter("empId")));
			st.setString(5, request.getParameter("identification"));


			
			// Execute the insert command using executeUpdate()
			// to make changes in database
			st.executeUpdate();

			// Close all the connections
			st.close();
			dbConn.closeConnection();
			// Get a writer pointer
			// to display the successful result
			PrintWriter out = response.getWriter();
			out.println("<b>Successfully Inserted"
					+ "</b>");

			HttpSession session = request.getSession();
			session.setAttribute("empId", Integer.parseInt(request.getParameter("empId")));
			session.setAttribute("type", request.getParameter("vehicleType"));
			session.setAttribute("vehicleNumber", request.getParameter("vehicleNumber"));
			RequestDispatcher rd = request.getRequestDispatcher("passPrice.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		catch(java.sql.SQLIntegrityConstraintViolationException e){
		PrintWriter out = response.getWriter();
		out.println("<html><body><b>email already exists"
				+ "</b><br/><br/></body></html>");
	}
	}
}
