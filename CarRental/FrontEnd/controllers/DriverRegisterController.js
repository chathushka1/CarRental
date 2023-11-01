const BASE_URL = "http://localhost:8081/BackEnd_war/";



var now = new Date();

var day = ("0" + now.getDate()).slice(-2);
var month = ("0" + (now.getMonth() + 1)).slice(-2);
var today = now.getFullYear() + "-" + (month) + "-" + (day);

$("#btnDriverSave").click(function (){
    alert("Saved");
    saveDriver();

});

function saveDriver(){
    var userrs={
    userId:$("#generateUserId").text(),
    username:$("#txtDriverUserName").val(),
    password:$("#txtDriverPassword").val(),
}
    var driverDetails= {
        dId: $("#generateDriverId").text(),
        userDTO:userrs,
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
                registerDriverUser(userrs);
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
    var test = "dId";

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
    generateUserIds();
});


function registerDriverUser(users){
    var userDTO={
        userId:users.userId,
        username:users.username,
        password:users.password,
    }

    $.ajax({
        url:BASE_URL+"driver",
        method:"POST",
        contentType:"application/json",
        data: JSON.stringify(userDTO),
        success:function (resp) {
            /*  alert(resp.message);*/
            console.log(resp);
            if (resp.message==200){
            }

        },
        error:function (error) {
            alert(JSON.parse(error.responseText).message);
        }
    });
}


function generateUserIds() {
    $("#generateUserId").text("U00-0001");
    var test = "id";

    $.ajax({
        url: BASE_URL+"user?test="+test,
        method: "GET",
        success: function (response) {
            var userId = response.data;
            var tempId = parseInt(userId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#generateUserId").text("U00-000" + tempId);
            } else if (tempId <= 99) {
                $("#generateUserId").text("U00-00" + tempId);
            } else if (tempId <= 999) {
                $("#generateUserId").text("U00-0" + tempId);
            } else {
                $("#generateUserId").text("U00-" + tempId);
            }

        },
        error: function (ob, statusText, error) {

        }
    });
}
