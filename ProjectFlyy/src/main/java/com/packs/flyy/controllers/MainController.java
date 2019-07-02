package com.packs.flyy.controllers;

import com.packs.flyy.models.entity.UsersProfiles;
import com.packs.flyy.models.response.ApiResponse;
import com.packs.flyy.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    UsersService usersService;

    @PostMapping("/auser")
    public ApiResponse addUser(@RequestBody UsersProfiles user){
        return usersService.addUser(user);
    }

    @GetMapping("/guser/{userid}")
    public ApiResponse getAllUsers(@PathVariable Long userid){
        return usersService.getUser(userid);
    }

    @DeleteMapping("duser/{userid}")
    public ApiResponse deleteUser(@PathVariable Long userid){
        return usersService.deleteUser(userid);
    }

}
