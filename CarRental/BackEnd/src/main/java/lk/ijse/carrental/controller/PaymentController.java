package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.PaymentDTO;
import lk.ijse.carrental.service.PaymentService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:46
 * 2023-11-02
 * FrontEnd
 */
@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    PaymentService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPayments() {
        return new ResponseUtil("Ok", "Ok", service.getAllPayments());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePayment(@RequestBody PaymentDTO dto) {
        System.out.println(dto.toString());
        service.savePayment(dto);
        return new ResponseUtil("Ok", "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updatePayment(@RequestBody PaymentDTO dto) {
        service.updatePayment(dto);
        return new ResponseUtil("Ok", "Updated", null);
    }

    @DeleteMapping(params = {"paymentId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deletePayment(@RequestParam String paymentId) {
        service.deletePayment(paymentId);
        return new ResponseUtil("Ok", "Deleted", null);
    }

    @GetMapping(path = "/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchPayment(@PathVariable String paymentId) {
        return new ResponseUtil("Ok", "Ok", service.searchPayment(paymentId));
    }

    @GetMapping(path = "/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPaymentsByDateRange(@PathVariable String fromDate, @PathVariable String toDate) {
        System.out.println(fromDate + "/" + toDate);
        return new ResponseUtil("Ok", "Ok", service.getAllPaymentsByDateRange(fromDate, toDate));
    }

    @GetMapping(path = "/getAll/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPaymentsByCustomerId(@PathVariable String customerId) {
        return new ResponseUtil("Ok", "Ok", service.getAllPaymentsByCustomerId(customerId));
    }

    @GetMapping(path = "/generatePaymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generatePaymentId() {
        return new ResponseUtil("Ok", "Ok", service.generatePaymentId());
    }

    @DeleteMapping(path = "/delete/{rentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deletePaymentByRentId(@PathVariable String rentId) {
        service.deletePaymentByRentId(rentId);
        return new ResponseUtil("Ok", "deleted", null);
    }

    @GetMapping(path = "/calculatePaidPayment/{rentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil calculatePaidPayment(@PathVariable String rentId) {
        return new ResponseUtil("Ok", "Ok", service.calculatePaidPayments(rentId));
    }

    @GetMapping(path = "/getSum/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getSumOfPaymentsCost(@PathVariable String fromDate, @PathVariable String toDate) {
        return new ResponseUtil("Ok", "Ok", service.getSumOfPaymentsByDateRange(fromDate, toDate));
    }
}
