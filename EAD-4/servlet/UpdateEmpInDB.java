
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  


@WebServlet("/upadateEmployee")  
public class UpdateEmpInDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void service(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {      
		 try {

				DBConnection dbConn = new DBConnection();
				
				int ID = Integer.parseInt(request.getParameter("id"));
					//	contact = Integer.parseInt(request.getParameter("contactNumber"));
				String name = request.getParameter("fullName"),
						gender = request.getParameter("gender"),
						email = request.getParameter("email"),
				organization= request.getParameter("organization");
				
				String query = "UPDATE `EAD-4`.`employee_detail` AS ED"
						+ " SET ED.fullName=\""+name+"\", gender=\""+gender+"\""
						+"\", email=\""+email+"\", contact="+4+", organization="+organization
						+" WHERE SI.ID="+ID;
				PreparedStatement st = dbConn.estabConn(query);


				try{
					st.executeUpdate(query);
					// Close all the connections
					st.close();
					dbConn.closeConnection();
					// Get a writer pointer
					// to display the successful result
					PrintWriter out = response.getWriter();
					out.println("<html><body><b>Successfully Updated"
							+ "</b><br><br>"
							+ "<button type=button onclick=\"window.location.href='showStudents'\";>"
							+ "show students</button></body></html>");
				} catch(java.sql.SQLIntegrityConstraintViolationException e){
					PrintWriter out = response.getWriter();
					out.println("<html><body><b>Duplicate entry for email"
							+ "</b><br><br>"
							+ "<button type=button onclick=\"window.location.href='showStudents'\";>"
							+ "show students</button></body></html>");
				}
				

				
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }

}
