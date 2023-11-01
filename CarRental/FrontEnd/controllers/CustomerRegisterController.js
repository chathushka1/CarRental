let BASE_URL = "http://localhost:8081/BackEnd_war/";

//add customer event
$("#btnCusSave").click(function (){
    alert("Saved");
    register();

   /* swal({
        title: "Confirmation!",
        text: "Driver Updated Successfully",
        icon: "success",
        button: "Close",
        timer: 2000
    });*/

});
/*function saveCustomer() {
    let customerID = $("#txtCustomerID").val();
    //check customer is exists or not?
    if (searchCustomer(customerID.trim()) == undefined) {

        let formData = $("#customerForm").serialize();
        $.ajax({
            url: BASE_URL + "customer",
            method: "post",
            headers:{
                Auth:"user=admin,pass=admin"
            },
            data: formData,
            success: function (res) {
                alert(res.message);
            },
            error: function (error) {
                alert(error.responseJSON.message);
            }
        });


    } else {
        alert("Customer already exits.!");
    }
}*/


var now = new Date();

var day = ("0" + now.getDate()).slice(-2);
var month = ("0" + (now.getMonth() + 1)).slice(-2);
var today = now.getFullYear() + "-" + (month) + "-" + (day);

function register(){
    var user={
        userId:$("#generateUserId").text(),
        username:$("#txtCustomerUserName").val(),
        password:$("#txtCustomerPassword").val(),
    }

    var cusDetails={
        customerId:$("#generateCusId").text(),
        users:user,
        registeredDate:today.toString(),
        customerName:$("#txtCustomerName").val(),
        customerEmail:$("#txtCusEmail").val(),
        customerNIC:$("#txtCusNic").val(),
        customerAddress:$("#txtCustomerAddress").val(),
        customerContact:$("#txtCusContact").val(),
        customerDrivingLicenseId:$("#txtCusDrivingLicense").val(),
        customerDrivingLicenseImage:$("#txtCusDrivingLicensePhoto").val()
    }

    $.ajax({
        url:BASE_URL+"customer",
        method:"POST",
        contentType:"application/json",
        data: JSON.stringify(cusDetails),
        success:function (resp) {
            if (resp.message==200){
                registerUser(user);
                generateUserIds();
                generateRegisterIds();
            }


        },
        error:function (error) {
            console.log(error);
        }
    });

}

function registerUser(users){
    var user={
        userId:users.userId,
        username:users.username,
        password:users.password,
    }

    $.ajax({
        url:BASE_URL+"user",
        method:"POST",
        contentType:"application/json",
        data: JSON.stringify(user),
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




/*
$("#btnCusUpdate").click(function () {
    let id = $("#txtCustomerID").val();
});
*/

/*function searchCustomer(id) {
    let resp = false;
    $.ajax({
        url: BASE_URL + 'customer',
        dataType: "json",
        headers:{
            Auth:"user=admin,pass=admin"
        },
        async: false,
        success: function (response) {
            let customers = response.data;
            resp = customers.find(function (customer) {
                //if the search id match with customer record
                //then return that object
                return customer.id == id;
            });

        },
        error: function (error) {
            resp=false;
            alert(error.responseJSON.message);
        }
    });
    return resp;
}*/

/*function getAllCustomers() {
    $.ajax({
        url: BASE_URL + 'customer',
        dataType: "json",
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (response) {
            let customers = response.data;
            for (let i in customers) {
                let cus = customers[i];
                let cusId = cus.cusId;
                let cusName = cus.cusName;
                let cusAddress = cus.cusAddress;
                let cusEmail = cus.cusEmail;
                let cusContact = cus.cusContact;
                let cusNic = cus.cusNic;
                let cusLicenseNum = cus.cusLicenseNum;
                let cusNicPhoto = cus.cusNicPhoto;
                let cusLicensePhoto = cus.cusLicensePhoto;


                let row = `<tr><td>${cusId}</td><td>${cusName}</td><td>${cusAddress}</td><td>${cusEmail}</td>
                            <td>${cusContact}</td><td>${cusNic}</td><td>${cusLicenseNum}</td><td>${cusNicPhoto}</td>
                            <td>${cusLicensePhoto}</td></tr>`;
                $("#tblCustomer").append(row);
            }

        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}*/


/*function updateCustomer(id) {
    if (searchCustomer(id) == undefined) {
        alert("No such Customer..please check the ID");
    } else {
        let consent = confirm("Do you really want to update this customer.?");
        if (consent) {
            let customer = searchCustomer(id)[0];
            //if the customer available can we update.?
            console.log(customer);
            let customerName = $("#txtCustomerName").val();
            let customerAddress = $("#txtCustomerAddress").val();
            let customerEmail = $("#txtEmail").val();
            let customerContact = $("#txtContact").val();
            let customerNic = $("#txtNic").val();
            let customerLicenseNumber = $("#txtDrivingLicen").val();
            let customerNicPhoto = $("#txtNicPhoto").val();
            let customerLicensePhoto = $("#txtDrivingLicenPhoto").val();


            customer.id = id;
            customer.name = customerName;
            customer.address = customerAddress;
            customer.email = customerEmail;
            customer.cusContact = customerContact;
            customer.cusNic = customerNic;
            customer.cusDrivingLicen = customerLicenseNumber;
            customer.cusNicPhoto = customerNicPhoto;
            customer.drivingLicensePhoto = customerLicensePhoto;




            $.ajax({
                url: BASE_URL + 'customer',
                method: 'put',
                headers:{
                    Auth:"user=admin,pass=admin"
                },
                contentType: "application/json",
                data: JSON.stringify(customer),
                success: function (resp) {
                    alert(resp.message);

                },
                error: function (error) {
                    alert(error.responseJSON.message);
                }
            });
        }
    }

}*/

function generateRegisterIds() {
    $("#generateCusId").text("C00-0001");
    var test = "id";

    $.ajax({

        url: BASE_URL+"customer?test="+test,
        method: "GET",
        success: function (response) {
            var customerId = response.data;
            var tempId = parseInt(customerId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#generateCusId").text("C00-000" + tempId);
            } else if (tempId <= 99) {
                $("#generateCusId").text("C00-00" + tempId);
            } else if (tempId <= 999) {
                $("#generateCusId").text("C00-0" + tempId);
            } else {
                $("#generateCusId").text("C00-" + tempId);
            }

        },
        error: function (ob, statusText, error) {

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



$("#btnGenerateID").click(function () {
    generateRegisterIds();
    generateUserIds();
});

$("#btnCusUpdate").click(function () {
    let formData = new FormData($("#customerForm")[0]);
    console.log(formData);
    $.ajax({
        url: BASE_URL + "customer/update",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            console.log(res)

        },
        error: function (error) {
            console.log(error);
        }
    });
});


