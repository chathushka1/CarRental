package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CarRentReturnDTO;
import lk.ijse.carrental.service.CarRentReturnService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 20:18
 * 2023-11-03
 * FrontEnd
 */
@RestController
@RequestMapping("/carRentReturn")
@CrossOrigin
public class CarRentReturnController {
    @Autowired
    CarRentReturnService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarRentReturns() {
        return new ResponseUtil("OK", "Ok", service.getAllCarRentReturns());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCarRentReturn(@RequestBody CarRentReturnDTO dto) {
        System.out.println(dto.toString());
        service.saveCarRentReturn(dto);
        return new ResponseUtil("OK", "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCarRentReturn(@RequestBody CarRentReturnDTO dto) {
        service.updateCarRentReturn(dto);
        return new ResponseUtil("OK", "Updated", null);
    }

    @DeleteMapping(params = {"returnId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCarRentReturn(@RequestParam String returnId) {
        service.deleteCarRentReturn(returnId);
        return new ResponseUtil("OK", "Deleted", null);
    }

    @GetMapping(path = "/{returnId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCarRentReturn(@PathVariable String returnId) {
        return new ResponseUtil("OK", "OK", service.searchCarRentReturn(returnId));
    }

    @GetMapping(path = "/generateReturnId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateReturnId() {
        return new ResponseUtil("OK", "Ok", service.generateReturnId());
    }
}
