
function collapseEmpForm(divId, h2Id){
    var formDisplay = document.getElementById(divId).style.display, 
        formIds = ["addEmployee","addVehicle","feedback","Price"],
        h2Ids = ["EmployeeRegistration","VehicleDetailsForm","GetInTouch","PriceList"];

    formIds.forEach(collapse);
    if(formDisplay == "none"){
        document.getElementById(divId).style.display="block";
    }
    else{
        document.getElementById(divId).style.display="none";
    }
}

function collapse(item){
    document.getElementById(item).style.display="none";
}