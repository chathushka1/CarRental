const BASE_URL = "http://localhost:8081/BackEnd_war/";

getLastLogUser();

function getLastLogUser() {
    $.ajax({
        url: "http://localhost:8081/BackEnd_war/login/getLastLogin",
        method: "GET",
        success: function (res) {
            let login = res.data;
            console.log(login.loginId);
            getAllDriverData(login.username, login.password);
        }
    })
}

function getAllDriverData(username, password) {
    $.ajax({
        url: "http://localhost:8081/BackEnd_war/driver/set/" + username + "/" + password,
        method: "GET",
        success: function (res) {
            let driver = res.data;
            console.log(driver);
            loadDriverSchedule(driver.licenceNo);
        }
    })
}

function loadDriverSchedule(licenceNo) {
    $('#bookingScheduleTable').empty();
    let status = "Accepted";
    $.ajax({
        url:"http://localhost:8081/BackEnd_war/CarRent/getCarRents/" + status + "/" + licenceNo,
        method:"GET",
        success:function (res) {
            for (let carRent of res.data) {
                let row = `<tr><td>${carRent.customer.customerId}</td><td>${carRent.customer.name}</td><td>${carRent.customer.contactNo}</td><td>${carRent.rentId}</td><td>${carRent.car.registrationNO}</td><td>${carRent.pickUpDate}</td><td>${carRent.returnDate}</td></tr>`;
                $('#bookingScheduleTable').append(row);
            }
        }
    })
}