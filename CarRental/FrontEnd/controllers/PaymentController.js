let BASE_URL = "http://localhost:8080/BackEnd_war/";


function loadAllPayments() {
    $('#tblPayments').empty();
    $.ajax({
        url: BASE_URL+"payment",
        method: "GET",
        success: function (res) {
            for (const payment of res.data) {
                let row = `<tr><td>${payment.paymentId}</td><td>${payment.date}</td><td>${payment.amount}</td><td>${payment.rental.rentId}</td><td>${payment.customer.customerId}</td></tr>`;
                $('#tblPayments').append(row);
            }
        }
    })
}
