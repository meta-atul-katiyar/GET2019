

function ValidateEmail(){
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  var inputText = document.getElementById("email");
  if(inputText.value.match(mailformat)){
    return true;
  }
  else{
    alert("emter valid email address!");
    document.getElementById("email").value = "";
    return false;
  }
}


function allLetter(){
  var letters = /^[A-Za-z\s]+$/;
  var inputtxt = document.getElementById("firstname");
  if((inputtxt.value.match(letters))){
    return true;
  }
  else{
    alert("not all charaters");
    document.getElementById("firstname").value = "";
    return false;
  }
}


function passEqual(){
  var pass = document.getElementById("password").value,
  confirmPass = document.getElementById("confirmpassword").value;
  if(pass != confirmPass){
    alert("password not matched");
    document.getElementById("confirmpassword").value = "";
    return false;
  }
  else{
    return true;
  }
}

function hideEmpDetail(){
  if(ValidateEmail() && allLetter() && passEqual()){
    document.getElementById("empDetail").style.display = "none";
    document.getElementById("vehicleForm").style.display = "block";
  }
}



function rateCard(){
    var type = document.getElementById("vehicleType").value,
      currency = document.getElementById("currencyName").value, 
      exchangeFromRupee = 1;
    
    if(currency == "USD"){
      exchangeFromRupee = 0.014;
    }
    else if(currency == "YEN"){
      exchangeFromRupee = 1.47;
    }

    document.getElementById("vehicleTypeName").innerHTML = document.getElementById(type).innerHTML;
    document.getElementById("NameOfCurrency").innerHTML = document.getElementById(currency).innerHTML;

    if(type == "cycle"){
      document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 5;
      document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 100;
      document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 500;
    }
    else if(type == "twoWheeler"){
      document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 10;
      document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 200;
      document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 1000;
    }
    else if(type == "fourWheeler"){
      document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 20;
      document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 500;
      document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 3500;
    }
    document.getElementById("rateTable").style.display = "block";
} 


function displayRate(){
  var vehicleName = document.getElementById("vehicleName").value,
    vehicleType = document.getElementById("vehicleType").value,
    vehicleNumber = document.getElementById("vehicleNumber").value,
    employeeId = document.getElementById("employeeId").value;

  if(vehicleName != "" && vehicleType != "select type" && vehicleNumber != "" && employeeId != ""){
    document.getElementById("vehicleForm").style.display = "none";
    document.getElementById("rateInfo").style.display = "block";
  }
}

function priceList(duration){
 var price = document.getElementById(duration).innerHTML;
 document.getElementById("pass").innerHTML = price;
}

function generatePass(){
  document.getElementById("pass").style.display = "block";
}

