<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, temp.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <script src="main.js"></script>
 
</head>
<body>

     <div id="rateInfo" style="display:block" align="center">
            <select id="currencyName" onchange="rateCard()">
                    <option>select type</option>
                    <option id="INR" value="INR">Indian Rupees</option>
                    <option id="USD" value="USD">US Dollars</option>
                    <option id="YEN" value="YEN">Japanese Yen</option>
                </select><br><br>
                
				<%!
				
				String daily = null;
				String monthly = null;
				String yearly = null;
				
				%>                
                <% 
            	

    			
                String vehicleType =  (String)session.getAttribute("type");
                
                
                System.out.println("vehicle type: " + vehicleType);
                
                Connection connection = null;
                
				
                try 
                {
        		
                	System.out.println("==============");
                	DBConnection dbConn = new DBConnection();
                
                System.out.println("connection reference: " + connection);
                

                
                // fetching plans for the selected vehicleType

                String query = "select * from `EAD-4`.`price_list` AS PL where vehicleType = '"+vehicleType+ "';";
                PreparedStatement st = dbConn.estabConn(query);
                ResultSet rs = st.executeQuery(query);
                
                rs.next(); 
                
                System.out.println("daily-monthly-yearly");
                daily = rs.getString(2); 
                
                
                System.out.println("daily: " + daily);
                monthly = rs.getString(3); 
                yearly = rs.getString(4); 
               }
            	catch (SQLException e) {
            			e.printStackTrace();
            	}
                
                %>
                
        <div id = "rateTable" style="display:block">
            <table>
                <tr id="vehicleType">
	            <%=vehicleType %> </tr>
                <tr>
                    <th> Duration</th>
                    <th id="NameOfCurrency"></th> 
                    
                </tr>
                <tr>
                    <th>one day  </th>
                    <th id="dailyPrice"><%=daily%></th>  
                    <th><button id = "dayPlanButton" type="button" onclick="priceList('dailyPrice')">SELECT</button></input></th>  
                </tr>
                <tr>
                    <th>one month  </th> 
                    <th id="monthlyPrice"><%=monthly%></th> 
                    <th><button id = "monthPlanButton" type="button" onclick="priceList('monthlyPrice')">SELECT</button></input></th>
                </tr>
                <tr>
                    <th>one year  </th> 
                    <th id="yearlyPrice"><%=yearly%></th> 
                    <th><button id = "yearPlanButton" type="button" onclick="priceList('yearlyPrice')">SELECT</button></input></th>
                </tr>
            </table>



            <button id = "getPass" type="button" onclick="generatePass()">GET PASS</button>

            <p id = "passID" style ="display:none"></p>
        </div> <br><br>
     
</body>
<script>
 // used to show the rate cards in different currency
  function rateCard()
  {

      var type1 = document.getElementById("vehicleType").value,
        currency = document.getElementById("currencyName").value, 
        exchangeFromRupee = 1;
      console.log("fffff: ",currency);
      console.log("dddd: ","${type}");
      if(currency == "USD"){
        exchangeFromRupee = 0.014;
      }
      else if(currency == "YEN"){
        exchangeFromRupee = 1.47;
      }
  
//      document.getElementById("vehicleTypeName").innerHTML = document.getElementById(type).innerHTML;
//      document.getElementById("NameOfCurrency").innerHTML = document.getElementById(currency).innerHTML;
  
      if("${type}" == "cycle"){
        document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 5;
        document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 100;
        document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 500;
      }
      else if("${type}" == "twoWheeler"){
        document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 10;
        document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 200;
        document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 1000;
      }
      else if("${type}" == "fourWheeler"){
        document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 20;
        document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 500;
        document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 3500;
      }
      document.getElementById("rateTable").style.display = "block";
  } 
  
  </script>
</html>