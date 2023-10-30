package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.service.CustomerService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    CustomerService customerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO dto){
        customerService.saveCustomer(dto);
        return new ResponseUtil("Ok", "Successfully Registered.",null);
    }


    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id){
        return new ResponseUtil("Ok", "Successfully Searched.",customerService.searchCustomer(id));
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        customerService.updateCustomer(dto);
        return new ResponseUtil("Ok", "Successfully Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseUtil("Ok", "Successfully Deleted.",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil("Ok", "Successfully Searched.",customerService.getAllCustomers());
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generateCustomerIds(@RequestParam String test) {
        return new ResponseUtil("Ok", "Successfully Searched.",customerService.generateCustomerIds());
    }

    @GetMapping(path ="/COUNT/{count}")
    public ResponseUtil countRegisteredCustomers(@PathVariable String count) {
        return new ResponseUtil("Ok", "Successfully Searched.",customerService.countRegisteredCustomers());
    }

    @GetMapping(path ="/NewUsers/{date}")
    public ResponseUtil countDailyRegisteredCustomers(@PathVariable String date) {
        return new ResponseUtil("Ok", "Successfully Searched.",customerService.countDailyRegisteredCustomers(date));
    }

    @GetMapping(path = "USER/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUserFromCustomer(@PathVariable("id") String id){
        return new ResponseUtil("Ok", "Successfully Searched.",customerService.searchUserFromCustomer(id));
    }

    @GetMapping(path = "/findValidNic/{nic}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findCustomerToReserve(@PathVariable("nic") String nic){
        return new ResponseUtil("Ok", "Successfully Searched.",customerService.findCustomerToReserve(nic));
    }


}
