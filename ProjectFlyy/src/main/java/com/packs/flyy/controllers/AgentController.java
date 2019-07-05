package com.packs.flyy.controllers;

import com.packs.flyy.constants.MessageConstants;
import com.packs.flyy.models.requests.LoginReq;
import com.packs.flyy.models.response.ApiResponse;
import com.packs.flyy.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
public class AgentController {

    @Autowired
    AgentServices agentServices;

    @GetMapping("/agenttest")
    public String agentTest(){
        return MessageConstants.SERVER_ALIVE;
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginReq loginReq){
       return agentServices.agentLogin(loginReq);
    }
}
