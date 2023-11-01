let BASE_URL = "http://localhost:8081/BackEnd_war/";

$("#btnCarSave").click(function (){
    alert("Saved");
    carRegister();
    generateCarRegisterIds();

});

function carRegister(){

    var carDetails={
        carId:$("#generateCarId").text(),
        registrationNo:$("#txtCarRegistrationNo").val(),
        colour:$("#txtVehicleColor").val(),
        brand:$("#txtVehicleBrand").val(),
        type:$("#txtVehicleType").val(),
        fuelType:$("#txtVehicleFuelType").val(),
        transmissionType:$("#txtVehicleTransmissionType").val(),
        noOfPassengers:$("#txtNOPassenger").val(),
        freeKmForDay:$("#txtFreeKmForDay").val(),
        freeKmForMonth:$("#txtFreeKmForMonth").val(),
        pricePerExtraKM:$("#txtPricePerExtraKm").val(),
        dailyRatePrice:$("#txtDailyRatePrice").val(),
        monthlyRatePrice:$("#txtMonthlyRatePrice").val(),
        totalDistanceTraveled:$("#txtWholeKm").val(),
        availableOrNot:$("#txtAvailable").val(),
        damageOrNot:$("#txtVehicleDamage").val(),
        underMaintainOrNot:$("#txtUnderMaintain").val(),
        fontViewImage:$("#txtFrontView").val(),
        backViewImage:$("#txtBackView").val(),
        sideViewImage:$("#txtSideView").val(),
        interiorViewImage:$("#txtInterior").val(),
        aRegisteredDate:today.toString()
    }

    $.ajax({
        url:BASE_URL+"car",
        method:"POST",
        contentType:"application/json",
        data: JSON.stringify(carDetails),
        success:function (resp) {
            if (resp.message==200){
                generateCarRegisterIds();
            }


        },
        error:function (error) {
            console.log(error);
        }
    });

}


function generateCarRegisterIds() {
    $("#generateCarId").text("CA00-0001");
    var test = "id";

    $.ajax({

        url: BASE_URL+"car?test="+test,
        method: "GET",
        success: function (response) {
            var carId = response.data;
            var tempId = parseInt(carId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#generateCarId").text("CA00-000" + tempId);
            } else if (tempId <= 99) {
                $("#generateCarId").text("CA00-00" + tempId);
            } else if (tempId <= 999) {
                $("#generateCarId").text("CA00-0" + tempId);
            } else {
                $("#generateCarId").text("CA00-" + tempId);
            }

        },
        error: function (ob, statusText, error) {

        }
    });
}