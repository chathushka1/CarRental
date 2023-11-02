package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.service.CarService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


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
    CarService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCars() {
        return new ResponseUtil("Ok", "Ok", service.getAllCars());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@RequestBody CarDTO dto) {
        service.saveCar(dto);
        return new ResponseUtil("Ok", "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDTO dto) {
        service.updateCar(dto);
        return new ResponseUtil("Ok", "Updated", null);
    }

    @DeleteMapping(params = {"registrationNo"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCar(@RequestParam String registrationNo) {
        service.deleteCar(registrationNo);
        return new ResponseUtil("Ok", "deleted", null);
    }

    @GetMapping(path = "/{registrationNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@PathVariable String registrationNo) {
        return new ResponseUtil("Ok", "Ok", service.searchCar(registrationNo));
    }

    @PutMapping(path = "/updateCarStatus/{registrationNO}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCarStatus(@PathVariable String registrationNO, @PathVariable String status) {
        service.updateCarStatus(registrationNO, status);
        return new ResponseUtil("Ok", "Ok", null);
    }

    @GetMapping(path = "/getByStatus/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarsByStatus(@PathVariable String status) {
        return new ResponseUtil("Ok", "Ok", service.getAllCarsByStatus(status));
    }

    @GetMapping(path = "/count/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCountOfCarsByStatus(@PathVariable String status) {
        return new ResponseUtil("Ok", "Ok", service.getCountOfCarsByStatus(status));
    }

    @PutMapping(path = "/up/{registrationID}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("frontImg") MultipartFile frontImg, @RequestPart("backImg") MultipartFile backImg, @RequestPart("interImg") MultipartFile interImg, @RequestPart("sideImg") MultipartFile sideImg, @PathVariable String registrationID) {
        try {
            String projectPath = String.valueOf(new File("H:\\Github Projects\\Easy-Car-Rental\\Car-Rental-FontEnd\\assets\\savedImages"));
            File uploadsDir = new File(projectPath + "\\Cars");
            uploadsDir.mkdir();
            frontImg.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + frontImg.getOriginalFilename()));
            backImg.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + backImg.getOriginalFilename()));
            interImg.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + interImg.getOriginalFilename()));
            sideImg.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + sideImg.getOriginalFilename()));

            String frontImgPath = projectPath + "\\Cars\\" + frontImg.getOriginalFilename();
            String backImgPath = projectPath + "\\Cars\\" + backImg.getOriginalFilename();
            String interImgPath = projectPath + "\\Cars\\" + interImg.getOriginalFilename();
            String sideImgPath = projectPath + "\\Cars\\" + sideImg.getOriginalFilename();

            service.updateCarFilePaths(frontImgPath, backImgPath, interImgPath, sideImgPath, registrationID);

            return new ResponseUtil("Ok", "Uploaded", null);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Error", null);
        }
    }

    @GetMapping(path = "/getRegNo/{type}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCarRegistrationNoByType(@PathVariable String type){
        return new ResponseUtil("Ok","Ok",service.getCarRegistrationNumbersByType(type));
    }
}
