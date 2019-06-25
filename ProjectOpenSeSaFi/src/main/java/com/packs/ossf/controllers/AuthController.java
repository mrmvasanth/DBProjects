package com.packs.ossf.controllers;

import com.packs.ossf.constants.MessageConstants;
import com.packs.ossf.models.requests.LoginRequest;
import com.packs.ossf.models.requests.SignUpRequest;
import com.packs.ossf.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/test")
    private String testOssf(){
        return MessageConstants.SERVER_ALIVE;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authenticationService.signup(signUpRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authenticationService.signin(loginRequest);
    }


}
