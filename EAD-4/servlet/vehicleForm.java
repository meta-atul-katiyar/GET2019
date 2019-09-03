
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  


@WebServlet("/VehicleForm")  
public class vehicleForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
        PrintWriter out=response.getWriter(); 
		try {
 
	        out.println("<h1>Add Vehicle</h1>");

	        int empId = Integer.parseInt(request.getParameter("empId"));
			out.print("<form action='./InsertVehicleData?empId="+empId+"' method='post'>");  

			out.print("Vehicle Name:<input name='vehicleName' minlength='2'  /><br><br>");
			out.print("Vehicle Type:<select id='vehicleType' name='vehicleType'>"
                    +"<option id = 'cycle' value='cycle'>cycle</option>"
                    +"<option id = 'twoWheeler' value='twoWheeler'>two Wheeler</option>"
                    +"<option id = 'fourWheeler' value='fourWheeler'>Four Wheeler</option>"
                    +"</select><br><br>");
			out.print("Vehicle Number:<input name='vehicleNumber' /><br><br>");			
			out.print("Employee Id:	<input name='empId'	value='"+empId+"' disabled/><br/><br/>");
			out.print("Identification:<textarea rows='2' cols='50' name='identification'></textarea><br><br>");
			out.print("<input type='submit'>");  

			 
			out.print("</form>");  
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
