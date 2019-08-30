

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


function classValid(){
	var classId = document.getElementById("class").value;
	if(classId < 0 && classId > 12){
		alert("enter number between 1 and 12");
	}
}

function ageValid(){
	var age = document.getElementById("class").value;
	if(age < 1 ){
		alert("enter valid age. ");
	}
}

