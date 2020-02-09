
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  


@WebServlet("/friends")  
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
        PrintWriter out=response.getWriter(); 
		try {
 
	        out.println("<h1>Friend List</h1>");
	        
	        String empId = request.getParameter("empId");
	        DBConnection dbConn = new DBConnection();
			String query = "SELECT * FROM `EAD-4`.`friends_list` AS FL "
					+ " WHERE FL.userId=\""+empId+"\";";
			PreparedStatement st = dbConn.estabConn(query),
					st1 = dbConn.estabConn(query);
	        
			ResultSet rs = st.executeQuery(query);
	        
	        
	        while(rs.next()){
	    	   String friendDetails = "SELECT * FROM `EAD-4`.`employee_detail` AS ED "
						+ " WHERE ED.ID="+rs.getInt(1)+";";
	    	   ResultSet rs1 = st1.executeQuery(friendDetails);
	    	   rs1.next();
	    	   //System.out.println(rs.getString(4));
	    	  
	    	   out.println("<a href='FetchEmployeeData?email="+rs1.getString(4)+"&password="+rs1.getString(5)+"'>"+rs1.getString(2)+"</a>"
	    	   		+ "<br/><br/><br/>");
	       }  
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
