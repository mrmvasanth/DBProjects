package com.packs.ossf.controllers;

import com.packs.ossf.constants.MessageConstants;
import com.packs.ossf.models.entity.User;
import com.packs.ossf.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/test")
    private String testOssf(){
        return MessageConstants.SERVER_ALIVE;
    }

    @GetMapping("/getallusers")
    private List<User> getAllUsers(){
        return usersService.getAllUsers();
    }
}
