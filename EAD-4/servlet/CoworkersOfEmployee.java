
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoworkersList")
public class CoworkersOfEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {

			out.println("<h1>Co-Workers</h1>");

			String organization = request.getParameter("organizationName");
			int empId = Integer.parseInt(request.getParameter("empId"));
			DBConnection dbConn = new DBConnection();
			String query = "SELECT * FROM `EAD-4`.`employee_detail` AS ED  "
					+ " WHERE ED.organization=\""+organization+"\""
					+ " AND ED.ID<>\""+empId+"\";";
			PreparedStatement st = dbConn.estabConn(query);

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				 System.out.println(rs.getString(4));

				out.println("<a href='FetchEmployeeData?email=" + rs.getString("email")
						+ "&password=" + rs.getString("password")+"'>"
						+rs.getString("fullName")
						+ "</a>" + "<br/><br/><br/>");
			}

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
