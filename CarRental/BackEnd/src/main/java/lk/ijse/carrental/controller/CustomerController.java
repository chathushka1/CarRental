package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.service.CustomerService;
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
 * 22:38
 * 2023-10-25
 * FrontEnd
 */

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil("Ok", "Ok", service.getAllCustomers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO dto) {
        System.out.println(dto.toString());
        service.saveCustomer(dto);
        return new ResponseUtil("Ok", "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        System.out.println("In");
        service.updateCustomer(dto);
        return new ResponseUtil("Ok", "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id) {
        service.deleteCustomer(id);
        return new ResponseUtil("Ok", "Deleted", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id) {
        return new ResponseUtil("Ok", "Ok", service.searchCustomer(id));
    }



    @GetMapping(path = "/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomerByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        if (service.findCustomerByUsername(username)) {
            if (service.findCustomerByPassword(password)) {
                return new ResponseUtil("Ok", "Login Successful", true);
            } else {
                return new ResponseUtil("Ok", "Incorrect Password", false);
            }
        } else {
            return new ResponseUtil("Ok", "Incorrect Username", false);
        }
    }

    @GetMapping(path = "/set/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findCustomerByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        return new ResponseUtil("Ok", "Ok", service.findCustomerByUsernameAndPassword(username, password));
    }

    @GetMapping(path = "/generateCustomerId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateCustomerId() {
        return new ResponseUtil("Ok", "Ok", service.generateCustomerId());
    }

    @PutMapping(path = "/updateStatus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomerStatus(@PathVariable String id) {
        service.updateCustomerStatus(id);
        return new ResponseUtil("Ok", "Updated Status", null);
    }

    @GetMapping(path = "/pending", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPendingCustomers() {
        return new ResponseUtil("Ok", "Ok", service.getAllPendingCustomers());
    }

    @GetMapping(path = "/accepted", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAcceptedCustomers() {
        return new ResponseUtil("Ok", "Ok", service.getAllAcceptedCustomers());
    }

    @PutMapping(path = "/up/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("nicf") MultipartFile nicf, @RequestPart("nicb") MultipartFile nicb, @RequestPart("licenceImg") MultipartFile licenceImg, @PathVariable String id) {
        try {
            String projectPath = String.valueOf(new File("H:\\Github Projects\\Easy-Car-Rental\\Car-Rental-FontEnd\\assets\\savedImages"));
            File uploadsDir = new File(projectPath + "\\Customers");
            uploadsDir.mkdir();
            nicf.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + nicf.getOriginalFilename()));
            nicb.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + nicb.getOriginalFilename()));
            licenceImg.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + licenceImg.getOriginalFilename()));

            String nicfPath = projectPath + "\\Customers\\" + nicf.getOriginalFilename();
            String nicbPath = projectPath + "\\Customers\\" + nicb.getOriginalFilename();
            String licenceImgPath = projectPath + "\\Customers\\" + licenceImg.getOriginalFilename();

            service.uploadCustomerImages(nicfPath, nicbPath, licenceImgPath, id);

            return new ResponseUtil("Ok", "Uploaded", null);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Error", null);
        }
    }

    @GetMapping(path = "/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCountOfRegisteredCustomers(){
        return new ResponseUtil("Ok","Ok",service.getCountOfCustomersRegistered());
    }

}
