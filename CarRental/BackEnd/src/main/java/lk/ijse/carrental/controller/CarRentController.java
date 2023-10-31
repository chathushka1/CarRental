package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CarRentDTO;
import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.service.CarRentService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 22:31
 * 2023-10-31
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
        return new ResponseUtil("Ok", "Successfully Searched.", service.getAllCarRents());
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
        return new ResponseUtil("OK", "Updated", null);
    }

    @DeleteMapping(params = {"rentId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCarRent(@RequestParam String rentId) {
        service.deleteCarRent(rentId);
        return new ResponseUtil("OK", "Deleted", null);
    }
}
