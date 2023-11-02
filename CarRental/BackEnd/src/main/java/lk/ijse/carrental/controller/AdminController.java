package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.AdminDTO;
import lk.ijse.carrental.service.AdminService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:17
 * 2023-11-02
 * FrontEnd
 */

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAdmins() {
        return new ResponseUtil("Ok", "Ok", service.getAllAdmins());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@RequestBody AdminDTO dto) {
        System.out.println(dto.toString());
        service.saveAdmin(dto);
        return new ResponseUtil("Ok", "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto) {
        service.updateAdmin(dto);
        return new ResponseUtil("Ok", "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@RequestParam String id) {
        service.deleteAdmin(id);
        return new ResponseUtil("Ok", "Deleted", null);
    }

    @GetMapping(path = "/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdminByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        if (service.findAdminByUserName(username)) {
            if (service.findAdminByPassWord(password)) {
                return new ResponseUtil("Ok", "Login Successful", true);
            } else {
                return new ResponseUtil("Ok", "Incorrect Password", false);
            }
        } else {
            return new ResponseUtil("Ok", "Incorrect Username", false);
        }
    }

    @GetMapping(path = "/generateAdminID")
    public ResponseUtil generateAdminId() {
        return new ResponseUtil("Ok", "Ok", service.generateAdminId());
    }
}