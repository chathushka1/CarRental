package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.LoginDTO;
import lk.ijse.carrental.service.LoginService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:05
 * 2023-11-02
 * FrontEnd
 */
@RestController
@RequestMapping("/login")
@CrossOrigin

public class LoginController {
    @Autowired
LoginService service;

    @GetMapping(path = "/getLastLogin",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getLastLoginId(){
        LoginDTO dto = service.searchLogin(service.getLastLoginId());
        return new ResponseUtil("OK","done",dto);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveLogin(@RequestBody LoginDTO dto){
        service.saveLogData(dto);
        return new ResponseUtil("OK","saved",null);
    }

    @GetMapping(path = "/generateLogId",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateLogId(){
        return new ResponseUtil("OK","ok",service.generateLoginId());
    }
}
