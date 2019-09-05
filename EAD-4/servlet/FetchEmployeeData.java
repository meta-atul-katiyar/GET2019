
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
  


@WebServlet("/FetchEmployeeData")
public class FetchEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
        PrintWriter out=response.getWriter(); 
		try {
			String email = request.getParameter("email"),
	        		password = request.getParameter("password");
			
			DBConnection dbConn = new DBConnection();
			String query = "SELECT * FROM `EAD-4`.`employee_detail` AS ED "
					+ " WHERE ED.email=\""+email+"\";";
			PreparedStatement st = dbConn.estabConn(query);
	        
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String p1 = rs.getString(5),
					p2 = password;
			if(p1.equals(p2)){
				int empId = rs.getInt(1);
				
		        request.getRequestDispatcher("EmployeeHome?empId="+empId).include(request, response);
			}
			else{
				  out.print("Sorry, username or password error!");  
		          request.getRequestDispatcher("login.htm").include(request, response); 
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
