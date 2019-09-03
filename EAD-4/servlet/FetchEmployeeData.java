
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  


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
				String name = rs.getString(2),
						gender = rs.getString(3),
						contact = rs.getString(6),
						organization = rs.getString(7);
				
				
				
				out.print("<html><head><style>");
				out.print(".topnav {"
						+"  overflow: hidden;"
						+"  background-color: #333;}"
						
						+".topnav a {"
						+"  float: left;"
						+"  color: #f2f2f2;"
						+"  text-align: center;"
						+"  padding: 14px 16px;"
						+"  text-decoration: none;"
						+"  font-size: 17px;}"

						+".topnav a:hover {"
						+"  background-color: #ddd;"
						+"  color: black;}"

						+".topnav a.active {"
						+"  background-color: #4CAF50;"
						+"  color: white;}"
						
						+"#profile-container {"
						+ "position: absolute;"
						+ "right: 0px;"
						+ "top: 60px;"
						+ "background-color: white;}"
						
						
						+"#profile-container img{"
						+ "position: relative;"
						+ "right: 0px;"
						+ "top: 0px;"
						+ "background-color: white;"
						+ "width: 120;"
						+ "height: 150}"
						
						+"#profile-container button{"
						+ "postion:relative;"
						+ "top:200px;"
						+ "right:0px}"
						
						+"</style>");
				
				out.print("<div class='topnav' name='topnav'>"
						+ "<a  href='#home'>Home</a>"
						+ "<a href='friends?empId="+rs.getInt(1)+"'>Friends</a>"
						+ "</div>"
						+ "<br/>");
				out.print("<div id='profile-container' '>");
				
				
				if(gender.equals("male")){
					out.print("<img src='"+ request.getContextPath() +"/images/default-profile-picture.jpg' alt='image'/>");
				}
				else{
					out.print("<img src='"+ request.getContextPath() +"/images/user_profile_female.jpg' alt='image'/>");
				}
				out.print("<button type=button  onclick='#'>change</button>"
						+"</div>");
				out.println("<body><h1>Welcome !<br/> "+name+"</h1><br/><br/>");
				out.print("<p>gender: "+gender+"<br/>");
				out.print("<p>contact: "+contact+"<br/>");
				out.print("<p>organization: "+organization+"</p><br/><br/>");
				
				 out.print("<button type=button onclick=\"window.location.href = 'UpdateStudent?id="+rs.getInt(1)
	                		+ "&fullName="+rs.getString(2)+"&gender="+rs.getString(3)
	                		+ "&email="+rs.getString(4)
	                		+ "&contactNumber="+rs.getInt(6)+"&organization="+rs.getString(7)+"';\">Edit</button><br/><br/>");
	               
				out.print("<button type=button onclick=\"window.location.href = 'VehicleForm'>"
						+ "Add New Vehicle</button>");
				
				
				out.print("</body>");
			}
			else{
				out.print("incorrect id or password");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
