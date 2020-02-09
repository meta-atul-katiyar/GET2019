
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Servlet Name 
@WebServlet("/EditEmployeeData")
public class EditUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		/*RequestDispatcher dispatcher = request.getRequestDispatcher(
			      "WebContent/functions.js");

			  dispatcher.include(request, response);*/
        PrintWriter out=response.getWriter(); 
		try {
 
	        out.println("<h1>Update user information</h1>");

			int ID = Integer.parseInt(request.getParameter("id")),
					contact = Integer.parseInt(request.getParameter("contactNumber"));
			String name = request.getParameter("fullName"),
					gender = request.getParameter("gender"),
					email = request.getParameter("email"),
			organization= request.getParameter("organization");
			
			out.println("<html><head>");
			out.println("<script  src=\"functions.js\"> </script></head>");
			out.print("<form action='./upadateEmployee' method='post'>");  
			out.print("ID:<input type='hidden' name='id' value='"+ID+"'/><br><br>");
			out.print("First Name:<input name='fullName' value='"+name+"'/><br><br>");
			out.print("gender:<input name='gender' value='"+gender+"'/><br><br>");
			out.print(" Email:<input type='hidden' name='email' value='"+email+"'/><br><br>");			
			out.print("Organization:<input name='organization' value='"+organization+"' onchange='classValid()'/><br><br>");
			out.print("Contact:<input name='contact' value='"+contact+"' onchange='ageValid()'/><br><br>");
			out.print("<input type='submit'>");  

			 
			out.print("</form></html>");  
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
