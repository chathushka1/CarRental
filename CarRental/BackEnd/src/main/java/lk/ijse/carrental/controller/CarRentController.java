package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CarRentDTO;
import lk.ijse.carrental.service.CarRentService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 00:10
 * 2023-11-03
 * FrontEnd
 */
@RestController
@RequestMapping("/CarRent")
@CrossOrigin
public class CarRentController {
    @Autowired
    CarRentService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarRents() {
        return new ResponseUtil("Ok", "Ok", service.getAllCarRents());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addCarRent(@RequestBody CarRentDTO dto) {
        System.out.println(dto.toString());
        service.addCarRent(dto);
        return new ResponseUtil("Ok", "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCarRent(@RequestBody CarRentDTO dto) {
        service.updateCarRent(dto);
        return new ResponseUtil("Ok", "Updated", null);
    }

    @DeleteMapping(params = {"rentId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCarRent(@RequestParam String rentId) {
        service.deleteCarRent(rentId);
        return new ResponseUtil("Ok", "Deleted", null);
    }

    @GetMapping(path = "/{rentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCarRent(@PathVariable String rentId) {
        return new ResponseUtil("Ok", "Ok", service.searchCarRent(rentId));
    }

    @PutMapping(path = "/{rentId}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCarRentStatus(@PathVariable String rentId, @PathVariable String status) {
        service.updateCarRentStatus(rentId, status);
        return new ResponseUtil("Ok", "Ok", null);
    }

    @GetMapping(path = "/get/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarRentsByStatus(@PathVariable String status) {
        return new ResponseUtil("Ok", "Ok", service.getCarRentsByStatus(status));
    }

    @GetMapping(path = "/getCarRents/{status}/{licenceNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarRentsByDrivingLicence(@PathVariable String status, @PathVariable String licenceNo) {
        return new ResponseUtil("Ok", "Ok", service.getCarRentsByDrivingLicenceNo(status, licenceNo));
    }

    @GetMapping(path = "/generateRentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateRentId() {
        return new ResponseUtil("Ok", "Ok", service.generateRentId());
    }

    @GetMapping(path = "/countTodayBookings/{today}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getTodayBookingCount(@PathVariable String today) {
        System.out.println(today);
        return new ResponseUtil("Ok", "Ok", service.getTodayBookingCount(today));
    }

    @GetMapping(path = "/getTodayBookings/{today}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getTodayBookings(@PathVariable String today) {
        return new ResponseUtil("Ok", "Ok", service.getTodayBookings(today));
    }

    @GetMapping(path = "/getMyCarRents/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getMyCarRents(@PathVariable String customerId) {
        return new ResponseUtil("Ok", "Ok", service.getCarRentsByCustomerId(customerId));
    }
}
