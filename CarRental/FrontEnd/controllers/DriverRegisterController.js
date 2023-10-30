const BASE_URL = "http://localhost:8080/BackEnd_war/";



$("#btnDriverSave").click(function (){
    alert("Saved");
    saveDriver();

});

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
        url:BASE_URL+"driver",
        method:"POST",
        contentType:"application/json",
        data: JSON.stringify(driverDetails),
        success:function (resp) {
            if (resp.message==200){
                generateDriverRegisterIds();
                saveDriver();
            }
            alert("Ok");

        },
        error:function (error) {
            console.log(error);
            alert("Error");
        }
    });

}


function generateDriverRegisterIds() {
    $("#generateDriverId").text("D00-0001");
    var test = "id";

    $.ajax({

        url: BASE_URL+"driver?test="+test,
        method: "GET",
        success: function (response) {
            var driverId = response.data;
            var tempId = parseInt(driverId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#generateDriverId").text("D00-000" + tempId);
            } else if (tempId <= 99) {
                $("#generateDriverId").text("D00-00" + tempId);
            } else if (tempId <= 999) {
                $("#generateDriverId").text("D00-0" + tempId);
            } else {
                $("#generateDriverId").text("D00-" + tempId);
            }

        },
        error: function (ob, statusText, error) {

        }
    });
}
$("#btnGenerateDriverID").click(function () {
    generateDriverRegisterIds();
});