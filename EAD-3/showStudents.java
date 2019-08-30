import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Servlet Name 
@WebServlet("/showStudents")
public class showStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
		try {

			DBConnection dbConn = new DBConnection("EAD-3");
			// Create a SQL query to insert data into demo table
			// demo table consists of two columns, so two '?' is used
			String query = "SELECT * FROM student_information;";
			PreparedStatement ps = dbConn.estabConn(query);
			
			 out.print("<table width=25% border=1>");

             out.print("<center><h1>Result:</h1></center>");

             ResultSet rs=ps.executeQuery(); 
             
             ResultSetMetaData rsmd=rs.getMetaData();

             out.print("<tr>");
             out.print("<th>"+rsmd.getColumnName(1)+"</th>");
             out.print("<th>"+rsmd.getColumnName(2)+"</th>");
             out.print("<th>"+rsmd.getColumnName(3)+"</th>");
             out.print("<th>"+rsmd.getColumnName(4)+"</th>");
             out.print("<th>"+rsmd.getColumnName(5)+"</th>");
             out.print("<th>"+rsmd.getColumnName(6)+"</th>");
             out.print("<th>"+rsmd.getColumnName(7)+"</th>");
             out.print("</tr>");
             
             while(rs.next()){
            	out.print("<tr>");
                out.print("<td>"+rs.getString(1)+"</td>");
                out.print("<td>"+rs.getString(2)+"</td>");
                out.print("<td>"+rs.getString(3)+"</td>");
                out.print("<td>"+rs.getString(4)+"</td>"); 
                out.print("<td>"+rs.getString(5)+"</td>");
                out.print("<td>"+rs.getString(6)+"</td>");
                out.print("<td>"+rs.getString(7)+"</td>");
                out.print("<td><button type=button onclick=\"window.location.href = 'UpdateStudent?id="+rs.getInt(1)
                		+ "&firstName="+rs.getString(2)+"&lastName="+rs.getString(3)
                		+ "&fatherName="+rs.getString(4)+"&email="+rs.getString(5)
                		+ "&class="+rs.getInt(6)+"&age="+rs.getInt(7)+"';\">update</button></td>");
                out.print("</tr>");
             }

             out.print("</table>");

			// Close all the connections
            out.close();
			ps.close();
			dbConn.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

