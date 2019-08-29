import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Servlet Name 
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		/*RequestDispatcher dispatcher = request.getRequestDispatcher(
			      "WebContent/functions.js");

			  dispatcher.include(request, response);*/
        PrintWriter out=response.getWriter(); 
		try {
 
	        out.println("<h1>Update Student</h1>");

			int ID = Integer.parseInt(request.getParameter("id")),
					classId = Integer.parseInt(request.getParameter("class")),
					age = Integer.parseInt(request.getParameter("age"));
			String fName = request.getParameter("firstName"),
					lName = request.getParameter("lastName"),
					fatherName = request.getParameter("fatherName"),
					email = request.getParameter("email");
			
			out.println("<html><head>");
			out.println("<script  src=\"functions.js\"> </script></head>");
			out.print("<form action='./upadateStudent1' method='post'>");  
			out.print("ID:<input type='hidden' name='id' value='"+ID+"'/><br><br>");
			out.print("First Name:<input name='firstName' value='"+fName+"'/><br><br>");
			out.print("Last Name:<input name='lastName' value='"+lName+"'/><br><br>");
			out.print("Father Name:<input name='fatherName' value='"+fatherName+"'/><br><br>");			
			out.print("Email:<input name='email' value='"+email+"'  onchange='ValidateEmail()'/><br><br>");
			out.print("Class:<input name='class' value='"+classId+"' onchange='classValid()'/><br><br>");
			out.print("Age:<input name='age' value='"+age+"' onchange='ageValid()'/><br><br>");
			out.print("<input type='submit'>");  

			 
			out.print("</form></html>");  
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
