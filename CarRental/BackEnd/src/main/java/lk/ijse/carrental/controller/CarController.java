package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.service.CarService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * `@authority` Chathushka Madumal
 * hp
 * 18:21
 * 2023-10-22
 * FrontEnd
 */

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@RequestBody CarDTO dto){
        carService.addCar(dto);
        return new ResponseUtil("Ok", "Successfully Registered.",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@PathVariable String id){
        return new ResponseUtil("Ok", "Successfully Searched.",carService.findCar(id));
    }

}
