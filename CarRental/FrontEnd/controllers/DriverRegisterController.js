const BASE_URL = "http://localhost:8080/BackEnd_war/";





function saveDriver(){

    var driverDetails= {
        dId: $("#txtDriverID").val(),
        dName :$("#txtDriverName").val(),
        dAddress :$("#txtDriverAddress").val(),
        dContact: $("#txtDriverContact").val(),
        dEmail:$("#txtDriverEmail").val(),
        dLicenseNumber: $("#txtDDrivingLicense").val(),
        dLicensePhoto: $("#txtDDrivingLicensePhoto").val(),
        registeredDate:today.toString()
    }

    $.ajax({
        url:BASE_URL+"customer",
        method:"POST",
        contentType:"application/json",
        data: JSON.stringify(cusDetails),
        success:function (resp) {
            if (resp.message==200){
                registerUser(user);
                generateRegisterIds();
            }
            alert("Ok");

        },
        error:function (error) {
            console.log(error);
            alert("Error");
        }
    });

}