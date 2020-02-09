<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, temp.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <script src="checks.js"></script>
 
</head>
<body>

     <div id="rateInfo" style="display:block" align="center">
            <select id="currencyName" onchange="rateCard()">
            		<option id="USD" value="USD">US Dollars</option>
            
                    <option id="INR" value="INR">Indian Rupees</option>
                    
                    <option id="YEN" value="YEN">Japanese Yen</option>
                </select><br><br>
                
				<%!
				
				double daily, monthly ,yearly;
				
				%>                
                <% 
            	

    			
                String vehicleType =  (String)session.getAttribute("type"),
                	vehicleNumber = (String)session.getAttribute("vehicleNumber");
                int vehicleId = -1, 
                		empId = (int)session.getAttribute("empId");
                
                // assign name to vehicle type
                if(vehicleType.equals("cycle")){
                	vehicleType = "Cycle";
                }
                else if(vehicleType.equals("twoWheeler")){
                	vehicleType = "Two Wheeler";
                }
                else if(vehicleType.equals("fourWheeler")){
                	vehicleType = "Four Wheeler";
                }
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
                
                daily = rs.getInt(3); 
                
                
                System.out.println("daily: " + daily);
                monthly = rs.getInt(4); 
                yearly = rs.getInt(5); 
                
            	// fetch vehicle Id
            	System.out.println("vNUM:"+vehicleNumber);
				String queryID = "select * from `EAD-4`.`vehicle_detail` AS VD WHERE VD.vehicleNumber = \""+vehicleNumber+ "\";";
				ResultSet rs1 = st.executeQuery(queryID);
				rs1.next();
				System.out.println("vId: "+rs1.getInt(1));
				vehicleId = rs1.getInt(1); 
				
				if(vehicleId == -1){
					throw new AssertionError("this vehicle is not registered.");
				}
               }
            	catch (SQLException e) {
            			e.printStackTrace();
            	}
                
                %>
          <form action='/GeneratePass' method='post'>      
        <div id = "rateTable" style="display:block">
            <table border='5px'>
                <tr id="vehicleType">Vehicle Type:  
	            <%=vehicleType %> </tr>
                <tr>
                    <th> Duration</th>
                    <th id="NameOfCurrency"></th> 
                    
                </tr>
                <tr>
                    <th>Daily </th>
                    <th id="dailyPrice">$<%=daily%></th>  
                    <th><input id='pricePlan' type="radio"  name='pricePlan' value='daily'" onclick="setAmount('daily')"></input></th>  
                </tr>
                <tr>
                    <th>Monthly  </th> 
                    <th id="monthlyPrice">$<%=monthly%></th> 
                    <th><input type='radio' id='pricePlan' name='pricePlan' value='monthly' onclick="setAmount('monthly')"></input></th>
                </tr>
                <tr>
                    <th>Yearly  </th> 
                    <th id="yearlyPrice">$<%=yearly%></th> 
                    <th><input type='radio' id='pricePlan' name='pricePlan' value='yearly' onclick="setAmount('yearly')"></input></th>
                </tr>
            </table></div>
			<input type='button' value= 'get pass' onclick='getPass()'/>
           </form>
			
			
			
<!--   			<label><input type='radio' id='pricePlan' name='pricePlan' value='daily' >Daily</label> -->
<!--                   <label><input type='radio' id='pricePlan' name='pricePlan' value='monthly'>Monthly</label> -->
<!--                    <label><input type='radio' id='pricePlan' name='pricePlan' value='yearly'>Yearly</label> -->
<!--                        <br> <br> -->

                

<!--             <button id = "getPass" type="button" onclick="GeneratePass?currency="+>GET PASS</button> -->

            <p id = "passID" style ="display:none"></p>
        </div> <br><br>
     
</body>
<script>
 // used to show the rate cards in different currency
 var vehicleId=<%=vehicleId%>, currency='USD', amount, planName, symbol="USD", empId=<%=empId%>;
  function rateCard()
  {
      var type1 = document.getElementById("vehicleType").value, 
        exchangeFromRupee = 1; 
      currency = document.getElementById("currencyName").value;
      
      console.log("fffff: ",currency);
      console.log("dddd: ","${type}");
      if(currency == "INR"){
        exchangeFromRupee = 72.02;
        symbol = "INR";
      }
      else if(currency == "YEN"){
        exchangeFromRupee = 106.24;
        symbol = "JPY";
      }
  
//      document.getElementById("vehicleTypeName").innerHTML = document.getElementById(type).innerHTML;
//      document.getElementById("NameOfCurrency").innerHTML = document.getElementById(currency).innerHTML;
  
  		const formatter = new Intl.NumberFormat('en-US', {
  style: 'currency',
  currency: symbol
})
      if("${type}" == "cycle"){
        document.getElementById("dailyPrice").innerHTML = formatter.format(exchangeFromRupee * 5) ;
        document.getElementById("monthlyPrice").innerHTML = formatter.format(exchangeFromRupee * 100);
        document.getElementById("yearlyPrice").innerHTML = formatter.format(exchangeFromRupee * 500);
      }
      else if("${type}" == "twoWheeler"){
        document.getElementById("dailyPrice").innerHTML = formatter.format(exchangeFromRupee * 10);
        document.getElementById("monthlyPrice").innerHTML = formatter.format(exchangeFromRupee * 200);
        document.getElementById("yearlyPrice").innerHTML = formatter.format(exchangeFromRupee * 1000);
      }
      else if("${type}" == "fourWheeler"){
        document.getElementById("dailyPrice").innerHTML = formatter.format(exchangeFromRupee * 20);
        document.getElementById("monthlyPrice").innerHTML = formatter.format(exchangeFromRupee * 500);
        document.getElementById("yearlyPrice").innerHTML = formatter.format(exchangeFromRupee * 3500);
      }
      document.getElementById("rateTable").style.display = "block";
  } 
  
  function setAmount(plan){
	  if(plan=="daily"){
		  amount = document.getElementById("dailyPrice").innerHTML;
		  planName = "daily";
	  }
	  else if(plan=="monthly"){
		  amount = document.getElementById("monthlyPrice").innerHTML;
		  planName = "monthly";
	  }
	  else if(plan == "yearly"){
		  amount = document.getElementById("yearlyPrice").innerHTML;
		  planName = "yearly";
	  }
	  //amount = amount.substring(0, str.length - 1);
  }
  console.log(currency);
  function getPass(){
	  window.location.assign("GeneratePass?planName="+planName+"&amount="+amount+"&vehicleId="+vehicleId+"&currency="+currency
			  +"&empId="+empId);
  }
  
  </script>
</html>
