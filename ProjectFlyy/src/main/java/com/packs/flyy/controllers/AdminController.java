package com.packs.flyy.controllers;

import com.packs.flyy.constants.MessageConstants;
import com.packs.flyy.models.entity.Users;


import com.packs.flyy.models.requests.LoginReq;
import com.packs.flyy.models.response.ApiResponse;
import com.packs.flyy.services.AdminServices;
import com.packs.flyy.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminServices adminServices;

    @GetMapping("/ttest")
    public String ttest(){
        return MessageConstants.SERVER_ALIVE;
    }

    @GetMapping("/ftest")
    public String ftest(){
        return MessageConstants.SERVER_ALIVE;
    }

    @PostMapping("/signup")
    public ApiResponse adminSignup(@RequestBody LoginReq loginReq){
        return adminServices.signup(loginReq);
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginReq adminLoginReq){
        return adminServices.login(adminLoginReq);
    }

    @PostMapping("/addagent")
    public ApiResponse addAgent(@RequestBody LoginReq loginReq){
        return adminServices.addAgent(loginReq);
    }

//    @PostMapping("/logout")
//    public ApiResponse logout(){
//        return
//    }



//    @PostMapping("/updatepassword")
//    public ApiResponse updatepassword(@RequestBody AdminLoginReq adminLoginReq){
//        return adminServices.login(adminLoginReq);
//    }





}
