import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  


@WebServlet("/upadateStudent1")  
public class UpdateInDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {      
		 try {

				DBConnection dbConn = new DBConnection("EAD-3");
				
				int ID = Integer.parseInt(request.getParameter("id")),
						classId = Integer.parseInt(request.getParameter("class")),
						age = Integer.parseInt(request.getParameter("age"));
				String fName = request.getParameter("firstName"),
						lName = request.getParameter("lastName"),
						fatherName = request.getParameter("fatherName"),
						email = request.getParameter("email");
				
				String query = "UPDATE `EAD-3`.`student_information` AS SI"
						+ " SET SI.firstName=\""+fName+"\", lastName=\""+lName+"\", fatherName=\""+fatherName
						+"\", email=\""+email+"\", class="+classId+", age="+age
						+" WHERE SI.ID="+ID;
				PreparedStatement st = dbConn.estabConn(query);


				int flag=0;
				try{
					st.executeUpdate(query);
				} catch(java.sql.SQLIntegrityConstraintViolationException e){
					flag = 1;
					PrintWriter out = response.getWriter();
					out.println("<html><body><b>Duplicate entry for email"
							+ "</b><br><br>"
							+ "<button type=button onclick=\"window.location.href='showStudents'\";>"
							+ "show students</button></body></html>");
				}
				

				// Close all the connections
				st.close();
				dbConn.closeConnection();
				// Get a writer pointer
				// to display the successful result
				PrintWriter out = response.getWriter();
				if(flag==0)
				out.println("<html><body><b>Successfully Updated"
						+ "</b><br><br>"
						+ "<button type=button onclick=\"window.location.href='showStudents'\";>"
						+ "show students</button></body></html>");
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }

}
