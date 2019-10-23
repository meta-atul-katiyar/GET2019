
var tempVar1, labelValue, name, gender, count = 0, vehicleType, daily, monthly, yearly;
var fieldList = ["Full Name", "Gender", "Email Id", "Password", "Contact Number",
    "Vehicle Name", "Type", "Vehicle Number", "Idntification",
    "Price List"];

var cycle = document.createElement('img'), twoWheeler = document.createElement('img'),
    fourWheeler = document.createElement('img');
cycle.src = 'bicycle.png';  //cycle.height="80px"; cycle.width="100px"
twoWheeler.src = 'bike.png'; //twoWheeler.height="80px"; twoWheeler.width="100px"
fourWheeler.src = 'car.png'; //fourWheeler.height="80px"; fourWheeler.width="100px"



function changeBorder() {

    count += 1;
    console.log(count);
    var pass = document.getElementById("Password").value
    if (pass.length >= 7) {
        document.getElementById("Password").style.borderColor = "yellow";
        if (pass.match(/[a-z]/g) && pass.match(
            /[A-Z]/g) && pass.match(
                /[0-9]/g) && pass.match(
                    /[^a-zA-Z\d]/g) && pass.length >= 8) {
            document.getElementById("Password").style.borderColor = "green";
        }
    }
    else if (pass.length < 7) {
        document.getElementById("Password").style.borderColor = "red";
    }
}

function changeCurrValue() {
    var currencyEx = 1, curr = document.getElementById("currencyList").value, symbol='USD';
    if (curr == "INR") {
        currencyEx = 70.89;
        symbol = 'INR';
    }
    else if (curr == "YEN") {
        currencyEx = 108.38;
        symbol = 'JPY';
    }
    else if (curr == "USD") {
        currencyEx = 1;
        
    }

    const formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: symbol
    })

    document.getElementById("radioLabel1").innerHTML = formatter.format(daily * currencyEx);
    document.getElementById("radioLabel2").innerHTML = formatter.format(monthly * currencyEx);
    document.getElementById("radioLabel3").innerHTML = formatter.format(yearly * currencyEx);

}



function showNextItem() {
    var indexOfFieldList = fieldList.indexOf(document.getElementById("labelText").innerHTML);
    tempVar1 = document.getElementById("inputField").value;

    // console.log(document.getElementById("labelText").innerHTML);


    switch (indexOfFieldList) {
        case 0:
            // code block
            name = tempVar1;
            var regName = /^[a-zA-Z]+ [a-zA-Z]+$/;
            if (!regName.test(tempVar1)) {
                alert('Please enter your full name (first & last name).');
                document.getElementById('name').focus();
                return false;
            } else {
                //   alert('Valid name given.');
                document.getElementById("labelText").innerHTML = fieldList[indexOfFieldList + 1];
                document.getElementById("hiWithName").innerHTML = "Hi, " + name;
                document.getElementById("messageForNextAction").innerHTML = "Now select your gender";
                document.getElementById("titleOnPage").style.display = "none";

                document.getElementById("inputField").style.display = "none";
                document.getElementById("radios").style.display = "block";
                document.getElementById("radioLabel1").innerHTML = "Male";
                document.getElementById("radioLabel2").innerHTML = "Female";
                document.getElementById("radioLabel3").innerHTML = "Other";
                return true;
            }
            break;

        case 1:
            // code block
            if (document.getElementById("radio1").checked) {
                gender = "Male";
            }
            else if (document.getElementById("radio2").checked) {
                gender = "Female";
            }
            else {
                gender = "Other";
            }

            document.getElementById("labelText").innerHTML = fieldList[indexOfFieldList + 1];
            document.getElementById("hiWithName").innerHTML = "Hi, " + name;
            document.getElementById("messageForNextAction").innerHTML = "Now enter your email id.";

            document.getElementById("inputField").value = "";
            document.getElementById("inputField").style.display = "block";
            document.getElementById("radios").style.display = "none";
            document.getElementById("radioLabel1").innerHTML = "";
            document.getElementById("radioLabel2").innerHTML = "";
            document.getElementById("radioLabel3").innerHTML = "";
            break;

        case 2:
            var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

            if (reg.test(tempVar1) == false) {
                alert('Invalid Email Address');
            }
            else {
                document.getElementById("labelText").innerHTML = fieldList[indexOfFieldList + 1];
                document.getElementById("hiWithName").innerHTML = "Hi, " + name;
                document.getElementById("messageForNextAction").innerHTML = "Now enter a password for your account.";

                document.getElementById("inputField").value = "";
                document.getElementById("inputField").style.display = "none";
                document.getElementById("Password").style.display = "block";
                document.getElementById("confirmPassHead").style.display = "block";
                document.getElementById("confirmPassword").style.display = "block";
            }
            break;

        case 3:
            tempVar1 = document.getElementById("Password").value;
            var confirmPass = document.getElementById("messageForNextAction").value,
                confirmPassword = document.getElementById("confirmPassword").value;
            console.log(tempVar1);
            if (tempVar1.match(/[a-z]/g) && tempVar1.match(
                /[A-Z]/g) && tempVar1.match(
                    /[0-9]/g) && tempVar1.match(
                        /[^a-zA-Z\d]/g) && tempVar1.length >= 8) {
                if (tempVar1 == confirmPassword) {
                    document.getElementById("labelText").innerHTML = fieldList[indexOfFieldList + 1];
                    document.getElementById("hiWithName").innerHTML = "Hi, " + name;
                    document.getElementById("messageForNextAction").innerHTML = "Now enter your contact number.";

                    document.getElementById("inputField").value = "";
                    document.getElementById("Password").style.display = "none";
                    document.getElementById("inputField").style.display = "block";
                    document.getElementById("inputField").type = "number";
                    document.getElementById("confirmPassHead").style.display = "none";
                    document.getElementById("confirmPassword").style.display = "none";
                }
                else {
                    alert('password does not match to confirm password');
                }

            }
            else {
                alert("At least 1 uppercase character, 1 lowercase character, 1 digit,  1 special character, Minimum 8 characters.");
            }

            break;

        case 4:
            // code block
            if (tempVar1.length == 10 || tempVar1.length == 7) {

                document.getElementById("labelText").innerHTML = fieldList[indexOfFieldList + 1];
                document.getElementById("hiWithName").innerHTML = "Hi, " + name;
                document.getElementById("messageForNextAction").innerHTML = "Now enter your vehicle name.";

                document.getElementById("inputField").value = "";
                document.getElementById("inputField").type = "text";


            }
            else {
                alert('enter 10 digit of mobile number or seven digit of phone number');
            }

            break;

        case 5:
            // code block

            document.getElementById("labelText").innerHTML = fieldList[indexOfFieldList + 1];
            document.getElementById("hiWithName").innerHTML = "Hi, " + name;
            document.getElementById("messageForNextAction").innerHTML = "Now select type of your vehicle";

            document.getElementById("inputField").style.display = "none";
            document.getElementById("radios").style.display = "block";


            document.getElementById('radioLabel1').appendChild(cycle);
            document.getElementById('radioLabel2').appendChild(twoWheeler);
            document.getElementById('radioLabel3').appendChild(fourWheeler);


            document.getElementById("radio1").value = "Cycle";
            document.getElementById("radio2").value = "Two Wheeler";
            document.getElementById("radio3").value = "Four Wheeler";


            document.getElementById("inputField").value = "";
            // document.getElementById("inputField").style.display = "block";



            break;


        case 6:
            // code block
            if (document.getElementById("radio1").checked) {
                vehicleType = "Cycle";
            }
            else if (document.getElementById("radio2").checked) {
                vehicleType = "Two Wheeler";
            }
            else {
                vehicleType = "Four Wheeler";
            }

            document.getElementById('radioLabel1').removeChild(cycle);
            document.getElementById('radioLabel2').removeChild(twoWheeler);
            document.getElementById('radioLabel3').removeChild(fourWheeler);

            document.getElementById("inputField").style.display = "block";
            document.getElementById("radios").style.display = "none";

            document.getElementById("labelText").innerHTML = fieldList[indexOfFieldList + 1];
            document.getElementById("hiWithName").innerHTML = "Hi, " + name + " you selected " + vehicleType;
            document.getElementById("messageForNextAction").innerHTML = "Now enter your vehicle number.";

            document.getElementById("inputField").value = "";
            document.getElementById("inputField").style.display = "block";
            document.getElementById("radios").style.display = "none";
            document.getElementById("submitButton".value) = "Get Pass";
            break;

        case 7:
            document.getElementById("labelText").innerHTML = fieldList[indexOfFieldList + 1];
            document.getElementById("hiWithName").innerHTML = "Hi, " + name + " you selected " + vehicleType;
            document.getElementById("messageForNextAction").innerHTML = "Your employee id = 1 \n Now enter your vehicle identification.";

            document.getElementById("inputField").value = "";
            document.getElementById("inputField").style.display = "block";

            break;

        case 8:
            var symbol = 'USD';
            if (vehicleType == "Cycle") {
                daily = 5;
                monthly = 100;
                yearly = 500;
            }
            else if (vehicleType == "Two Wheeler") {
                daily = 10;
                monthly = 200;
                yearly = 1000;
            }
            else if (vehicleType == "Four Wheeler") {
                daily = 20;
                monthly = 500;
                yearly = 3500;
            }

            const formatter = new Intl.NumberFormat('en-US', {
                style: 'currency',
                currency: symbol
            })

            document.getElementById("radioLabel1").innerHTML = formatter.format(daily);
            document.getElementById("radioLabel2").innerHTML = formatter.format(monthly);
            document.getElementById("radioLabel3").innerHTML = formatter.format(yearly);

            document.getElementById("radios").style.display = "block";
            document.getElementById("currDiv").style.display = "block";

            document.getElementById("inputField").style.display = "none";

            document.getElementById("labelText").innerHTML = fieldList[indexOfFieldList + 1];
            document.getElementById("hiWithName").innerHTML = "Hi, " + name + " you selected " + vehicleType;
            document.getElementById("messageForNextAction").innerHTML = "Now select a plan";

            document.getElementById("inputField").value = "";
            document.getElementById("inputField").type = "text";


            break;


        case 9:
            var price;
                if (document.getElementById("radio1").checked) {
                    price = daily;
                }
                else if (document.getElementById("radio2").checked) {
                    price = monthly;
                }
                else {
                    price = yearly;
                }


            document.getElementById("radios").style.display = "none";
            document.getElementById("currDiv").style.display = "none";

            document.getElementById("labelText").style.display = "none";
            document.getElementById("hiWithName").innerHTML = "Hi, " + name + " \n your employee id: 1 "
                    +" \nyour vehicle: " + vehicleType;
            document.getElementById("messageForNextAction").innerHTML = "amount to be paid $"+price;

            document.getElementById("inputField").value = "";
            document.getElementById("buttons").style.display = "none";


            break;


        default:
        // code block
    }

}

function blankInputField() {
    document.getElementById("inputField").value = "";
}



