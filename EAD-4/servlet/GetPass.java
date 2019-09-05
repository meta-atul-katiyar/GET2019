
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  


@WebServlet("/GeneratePass")  
public class GetPass extends HttpServlet {
	
	
    		
	
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
        PrintWriter out=response.getWriter(); 
		try {
			
			int empId =Integer.parseInt(request.getParameter("empId"));
			String amount = request.getParameter("amount"),
					currency = request.getParameter("currency");
			System.out.println("amount: "+amount);
			  if (amount != null && amount.length() > 0) {
				  if(amount.charAt(0)=='$' || amount.charAt(0)=='?'){
					  amount = amount.substring(1);
				  }
				  
				  else if(amount.charAt(0)=='&'){
					  amount = amount.split(";")[1];
				  }
				  else{
					  amount = amount.substring(1); 
				  }
				  
				  String[] temp = amount.split(",");
				  amount="";
				  for(int count = 0; count<temp.length;count++){
					  amount+=temp[count];
				  }
				  
			    }
			 double amount1 = Double.parseDouble(amount);
			 if(currency.equals("YEN")){
				 amount1 /= 106.24;
			 }
			 else if(currency.equals("INR")){
				 amount1 /= 72.02;
			 }
			//System.out.println(currency);
			DBConnection dbConn = new DBConnection();
			String query = "INSERT INTO `EAD-4`.`pass_details`"
					+ " (amount, planName, generationTime, vehicleId)"
					+ " values(?, ?, now(), ?)";
			PreparedStatement st = dbConn.estabConn(query);
			System.out.println("Vnum:  "+ request.getParameter("vehicleId"));
			
			st.setDouble(1, amount1);
			st.setString(2, request.getParameter("planName"));
			st.setInt(3, Integer.parseInt(request.getParameter("vehicleId")));			
			// Execute the insert command using executeUpdate()
			// to make changes in database
			st.executeUpdate();
			
			// Close all the connections
			st.close();
			dbConn.closeConnection();
			
			request.getRequestDispatcher("EmployeeHome?empId="+empId).include(request, response);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
