

function ValidateEmail(){
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  var inputText = document.getElementById("email");
  if(inputText.value.match(mailformat)){
    return true;
  }
  else{
    alert("emter valid email address!");
    return false;
  }
}

function passValid(){
  var pass = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,20}$/,
    password = document.getElementById("password").value;
  if(password.match(pass)){
    return true;
  }
  else{
    alert("password must contain one numeric, one small letter, one capital letter, one of these !@#$%^&* and length between 6-20");
    return false;
  }
}

function contactValid(){
  var cont = /^(?=.*\d).{8,}$/,
    contact =  document.getElementById("contactNumber").vlaue;
  if(contact.match(cont)){
    return true;
  }
  else{
    alert("enter valid number");
  }
}

function allLetter(){
  var letters = /^[A-Za-z\s]+$/;
  var inputtxt = document.getElementById("fullName");
  if((inputtxt.value.match(letters))){
    return true;
  }
  else{
    alert("enter valid name");
    return false;
  }
}


function passEqual(){
  var pass = document.getElementById("password").value,
  confirmPass = document.getElementById("confirmPassword").value;
  if(pass != confirmPass){
    alert("password not matched");
    document.getElementById("confirmPassword").value = "";
    return false;
  }
  else{
    return true;
  }
}

function hideEmpDetail(){
  if(ValidateEmail() && allLetter() && passEqual()){
    document.getElementById("empDetail").style.display = "none";
    document.getElementById("successfulRegister").innerHTML = "welcome, successfully register by E12/000000"
    document.getElementById("vehicleForm").style.display = "block";

  }
}




function vNumValid(){
  var vehicleNum = /^[A-Z][A-Z]\d\d[A-Z][A-Z]\d{4}$/,
    vnum = document.getElementById("vehicleNumber").value;

    if(vnum.match(vehicleNum)){
      return true;
    }
    else{
      alert("vehicle number is not in format");
    }
}

function empIdValid(){
  var empId = /^[E]\d\d[/]\d\d\d\d\d\d$/,
    emp = document.getElementById("employeeId").value;
  if(emp.match(empId)){
    return true;
  }
  else{
    alert("employee ID is not in format");
  }
}






// used to show the rate cards in different currency
function rateCard()
{
    var type = document.getElementById("vehicleType").value,
      currency = document.getElementById("currencyName").value, 
      exchangeFromRupee = 1;
    console.log("fffff: ",currency);
    if(currency == "USD"){
      exchangeFromRupee = 0.014;
    }
    else if(currency == "YEN"){
      exchangeFromRupee = 1.47;
    }

//    document.getElementById("vehicleTypeName").innerHTML = document.getElementById(type).innerHTML;
//    document.getElementById("NameOfCurrency").innerHTML = document.getElementById(currency).innerHTML;

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


// generate a price message for selected of selected plan
function priceList(duration)
{
  var price = document.getElementById(duration).innerHTML;
  document.getElementById("passID").innerHTML = "Pass price of your selected plan is" + price;
 }
 
 // function to generate pass for selected plan
 function generatePass()
 {
   document.getElementById("passID").style.display = "block";
 }



