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
}
