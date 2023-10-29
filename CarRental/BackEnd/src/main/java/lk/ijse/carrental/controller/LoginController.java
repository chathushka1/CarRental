package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.LoginDTO;
import lk.ijse.carrental.service.LoginService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import java.awt.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 21:44
 * 2023-10-29
 * FrontEnd
 */

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService service;

   /* @GetMapping
    public ResponseUtil getLastLoginId(){
        LoginDTO dto = service.searchLogin(service.getLastLoginId());
        return new ResponseUtil(200,"done",dto);
    }
*/
}
