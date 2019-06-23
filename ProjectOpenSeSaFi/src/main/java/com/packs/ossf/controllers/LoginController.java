package com.packs.ossf.controllers;

import com.packs.ossf.models.LoginModel;
import com.packs.ossf.models.RegisterUserModel;
import com.packs.ossf.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ossf/api")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/test")
    private String testOssf(){
        return "Ossf Server Alive";
    }

    @PostMapping("/register")
    private String register(@RequestBody RegisterUserModel registerUser){
        return loginService.registerUser(registerUser);
    }

    @PostMapping("/loginddddd")
    private String loginddd(@RequestBody LoginModel loginModel) throws Exception {
        return loginService.login(loginModel);
    }

    @RequestMapping("/login")
    private String login() throws Exception {
        return "logged In";
    }

    @RequestMapping("/loggedout")
    private String loggedout() throws Exception {
        return "logged Out";
    }




}
