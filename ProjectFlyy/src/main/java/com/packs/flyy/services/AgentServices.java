package com.packs.flyy.services;

import com.packs.flyy.models.requests.LoginReq;
import com.packs.flyy.models.response.ApiResponse;
import com.packs.flyy.security.utils.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AgentServices {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;


    public ApiResponse agentLogin(LoginReq loginReq){
        //Use authentication manager to validate
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReq.getUsername(),loginReq.getPassword())
        );

        //Generate JWT for valid user and return in response
        String jwt = tokenProvider.generateToken(authentication);
        return new ApiResponse(jwt,200,HttpStatus.OK);
    }
}
