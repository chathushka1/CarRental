const BASE_URL = "http://localhost:8080/BackEnd_war/";

//add customer event
$("#btnCusSave").click(function () {
    /*if (checkAll()) {
        saveCustomer();
    } else {
        alert("Error");
    }*/

    saveCustomer();
});
function saveCustomer() {
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
}

$("#btnCusUpdate").click(function () {
    let id = $("#txtCustomerID").val();
    updateCustomer(id);

});

function searchCustomer(id) {
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
}


function updateCustomer(id) {
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

}