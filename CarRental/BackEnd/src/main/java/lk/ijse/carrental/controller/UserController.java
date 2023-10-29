package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.UserDTO;
import lk.ijse.carrental.service.UserService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 22:23
 * 2023-10-29
 * FrontEnd
 */

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return new ResponseUtil("Ok","Successfully Registered",userDTO);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUser(@PathVariable String id){
        return new ResponseUtil("Ok","Successfully Searched",userService.searchUser(id));

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return new ResponseUtil("Ok","Successfully Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(@RequestParam String id){
        userService.deleteUser(id);
        return new ResponseUtil("Ok","Successfully Deleted",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUsers(){
        return new ResponseUtil("Ok","Successfully Searched",userService.getAllUsers());
    }


    @GetMapping(params = {"test"})
    public ResponseUtil generateUserIds(@RequestParam String test) {
        return new ResponseUtil("Ok","Successfully Searched",userService.generateUserIds());
    }

    @GetMapping(path ="/{password}/{username}")
    public ResponseUtil findByPasswordAndUsername(@PathVariable("password") String password, @PathVariable("username") String username){
        return new ResponseUtil("Ok","Successfully Searched",userService.findByPasswordAndUsername(password,username));
    }


    @GetMapping(path ="/FIND/{uname}")
    public ResponseUtil findByUsername(@PathVariable("uname") String uname){
        return new ResponseUtil("Ok","Successfully Searched",userService.findByUsername(uname));
    }

}
