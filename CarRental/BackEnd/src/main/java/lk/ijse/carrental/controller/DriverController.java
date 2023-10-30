package lk.ijse.carrental.controller;


import lk.ijse.carrental.dto.DriverDTO;
import lk.ijse.carrental.service.DriverService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    DriverService driverService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addDriver(@RequestBody DriverDTO dto){
        driverService.addDriver(dto);
        return new ResponseUtil("Ok", "Successfully Registered.",null);
    }
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findDriver(@PathVariable String id){
        return new ResponseUtil("Ok", "Successfully Searched.",driverService.findDriver(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        driverService.updateDriver(dto);
        return new ResponseUtil("Ok", "Successfully Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String id){
        driverService.deleteDriver(id);
        return new ResponseUtil("Ok", "Successfully Deleted.",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriver(){
        return new ResponseUtil("Ok", "Successfully Searched.",driverService.getAllDriver());
    }
    @GetMapping(params = {"test"})
    public ResponseUtil generateCustomerIds(@RequestParam String test) {
        return new ResponseUtil("Ok", "Successfully Searched.",driverService.generateDriverIds());
    }

    @GetMapping(path ="/COUNT/{count}")
    public ResponseUtil countRegisteredDriver(@PathVariable String count) {
        return new ResponseUtil("Ok", "Successfully Searched.",driverService.countRegisteredDrivers());
    }

    @GetMapping(path = "USER/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUserFromDriver(@PathVariable("id") String id){
        return new ResponseUtil("Ok", "Successfully Searched.",driverService.findDriver(id));
    }

    @GetMapping(path = "/findValidNic/{nic}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findDriverToReserve(@PathVariable("nic") String nic){
        return new ResponseUtil("Ok", "Successfully Searched.",driverService.findDriverToReserve(nic));
    }
}
