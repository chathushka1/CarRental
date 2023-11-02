package lk.ijse.carrental.controller;


import lk.ijse.carrental.dto.DriverDTO;
import lk.ijse.carrental.service.DriverService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 08:22
 * 2023-10-27
 * FrontEnd
 */

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers() {
        return new ResponseUtil("OK", "Ok", service.getAllDrivers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@RequestBody DriverDTO dto) {
        System.out.println(dto.toString());
        service.saveDriver(dto);
        return new ResponseUtil("OK", "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody DriverDTO dto) {
        service.updateDriver(dto);
        return new ResponseUtil("OK", "Updated", null);
    }

    @DeleteMapping(params = {"licenceNo"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String licenceNo) {
        service.deleteDriver(licenceNo);
        return new ResponseUtil("OK", "Deleted", null);
    }

    @GetMapping(path = "/{licenceNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@PathVariable String licenceNo) {
        return new ResponseUtil("OK", "Ok", service.searchDriver(licenceNo));
    }

    @GetMapping(path = "/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriverByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        if (service.findDriverByUsername(username)) {
            if (service.findDriverByPassword(password)) {
                return new ResponseUtil("OK", "Login Successful", true);
            } else {
                return new ResponseUtil("OK", "Incorrect Password", false);
            }
        } else {
            return new ResponseUtil("OK", "Incorrect Username", false);
        }
    }

    @GetMapping(path = "/set/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findDriverByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        return new ResponseUtil("OK", "Ok", service.findDriverByUsernameAndPassword(username, password));
    }

    @PutMapping(path = "/updateAvailable/{licenceNo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriverAvailable(@PathVariable String licenceNo){
        service.updateDriverAvailable(licenceNo);
        return new ResponseUtil("OK","Updated",null);
    }

    @PutMapping(path = "/updateNonAvailable/{licenceNo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriverNonAvailable(@PathVariable String licenceNo){
        service.updateDriverNonAvailable(licenceNo);
        return new ResponseUtil("OK","Ok",null);
    }

    @GetMapping(path = "/getAllAvailableDrivers",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAvailableDrivers(){
        return new ResponseUtil("OK","Ok",service.getAllAvailableDrivers());
    }

    @GetMapping(path = "/getAllNonAvailableDrivers",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllNonAvailableDrivers(){
        return new ResponseUtil("OK","Ok",service.getAllNonAvailableDrivers());
    }

    @GetMapping(path = "/count/{availability}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCountOfCustomersByAvailability(@PathVariable boolean availability){
        return new ResponseUtil("OK","Ok",service.getCountOfDriversByStatus(availability));
    }

    @GetMapping(path = "/getRandomDriver",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getRandomDriver(){
        return new ResponseUtil("OK","Ok",service.getRandomDriver());
    }
}
