import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Blob;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmployeeHome")
public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			int empId = Integer.parseInt(request.getParameter("empId"));
			String photo = null;
			DBConnection dbConn = new DBConnection();
			String query = "SELECT * FROM `EAD-4`.`employee_detail` AS ED  "
					+ " WHERE ED.ID=\"" + empId + "\";",
					queryImage = "SELECT * FROM `EAD-4`.`profile` AS PP"
					+ " WHERE PP.employeeId=\"" + empId + "\";";
			
			String queryPass = "SELECT * FROM (employee_detail AS ED NATURAL JOIN vehicle_detail AS VD)"
					+ " NATURAL JOIN pass_details AS PD WHERE ED.ID=\""+empId+"\";";
					
			PreparedStatement st = dbConn.estabConn(query), 
					st1 = dbConn.estabConn(queryImage),
					st2 = dbConn.estabConn(queryPass);

			ResultSet rs = st.executeQuery(query);
			rs.next();

			String name = rs.getString(2), gender = rs.getString(3), contact = rs
					.getString(6), organization = rs.getString(7);
			
			ResultSet rs1 = st1.executeQuery(queryImage),
					rs2 = st2.executeQuery(queryPass);
			
			rs1.next();
			if (rs1.getRow() > 0) {
				photo = rs1.getString(2);
				//System.out.println(photo);
			}
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setMaxInactiveInterval(5 * 60);

			ServletContext context = getServletContext();
			context.setAttribute("empId", empId);

			out.print("<html><head><style>");
			out.print(".topnav {" + "  overflow: hidden;"
					+ "  background-color: #333;}"

					+ ".topnav a {" + "  float: left;" + "  color: #f2f2f2;"
					+ "  text-align: center;" + "  padding: 14px 16px;"
					+ "  text-decoration: none;" + "  font-size: 17px;}"

					+ ".topnav a:hover {" + "  background-color: #ddd;"
					+ "  color: black;}"

					+ ".topnav a.active {" + "  background-color: #4CAF50;"
					+ "  color: white;}"

					+ "#profile-container {" + "position: absolute;"
					+ "right: 0px;" + "top: 60px;"
					+ "background-color: white;}"

					+ "#profile-container img{" + "position: relative;"
					+ "right: 0px;" + "top: 0px;" + "background-color: white;"
					+ "width: 120;" + "height: 150}"

					+ "#profile-container button{" + "postion:relative;"
					+ "top:240px;" + "right:0px}"

					+ "</style>");

			out.print("<div class='topnav' name='topnav'>"
					+ "<a  href='#home'>Home</a>" 
					+ "<a href='friends?empId="
					+ empId + "'>Friends</a>"
					+ "<a href='CoworkersList?organizationName="+organization+"&empId="+empId+"'>Coworkers</a>"
					+ "<a href='Logout' style=\"float:right;\">Logout</a>"
					+ "</div>" + "<br/>");
			out.print("<div id='profile-container' '>");
			
			
			if (photo != null) {
				System.out.println(request.getContextPath());
				out.print("<img src='"
						+ request.getContextPath()
						+ "/images/"+photo+"' alt='image' />");
			} else {
				if (gender.equals("male")) {
					out.print("<img src='"
							+ request.getContextPath()
							+ "/images/default-profile-picture.jpg' alt='image'/>");
				} else {
					out.print("<img src='" + request.getContextPath()
							+ "/images/user_profile_female.jpg' alt='image'/>");
				}
			}
			// out.print("<form action='imageForm.jsp?empId="+empId+"'>");
			out.print("<button type=submit value='change' onclick= \"window.location.href = 'imageForm.jsp?empId="
					+ empId + "'\" >change</button>"
					// + "</form>"
					+ "</div>");
			out.println("<body><h1>Welcome !<br/> " + name + "</h1><br/><br/>");
			out.print("<p>gender: " + gender + "<br/>");
			out.print("<p>contact: " + contact + "<br/>");
			out.print("<p>organization: " + organization + "</p><br/><br/>");
			
			while(rs2.next()){
				out.print("<p>vehicle name: " + rs2.getString("vehicleName") + "<br/>");
				out.print("<p>vehicle type: " + rs2.getString("type") + "<br/>");
				out.print("<p>vehicle number: " + rs2.getString("vehicleNumber") + "<br/>");
				out.print("<p>identification: " + rs2.getString("identification") + "<br/>");
				out.print("<p>plan name: " + rs2.getString("planName") + "<br/>");
				out.print("<p>amount paid(USD): " + rs2.getString("amount") + "<br/>");
				out.print("<p>pass generation time: " + rs2.getString("generationTime") + "<br/><br/><br/>");
				
			}

			out.print("<button type=button onclick=\"window.location.href = 'EditEmployeeData?id="
					+ rs.getInt(1)
					+ "&fullName="
					+ rs.getString(2)
					+ "&gender="
					+ rs.getString(3)
					+ "&email="
					+ rs.getString(4)
					+ "&contactNumber="
					+ rs.getInt(6)
					+ "&organization="
					+ rs.getString(7)
					+ "';\">Edit</button><br/><br/>");

			out.print("<button type=button onclick=\"window.location.href = 'VehicleForm?empId="
					+ empId + "'\">" + "Add New Vehicle</button>");

			out.print("</body>");

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
