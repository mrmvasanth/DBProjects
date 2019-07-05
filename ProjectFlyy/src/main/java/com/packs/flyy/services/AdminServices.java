package com.packs.flyy.services;

import com.packs.flyy.models.entity.Admin.AdminProfiles;
import com.packs.flyy.models.entity.Agent.AgentProfiles;
import com.packs.flyy.models.entity.Users;
import com.packs.flyy.models.requests.LoginReq;
import com.packs.flyy.models.response.ApiResponse;
import com.packs.flyy.repositories.AdminProfileRepository;
import com.packs.flyy.repositories.AgentProfileRepository;
import com.packs.flyy.repositories.RolesRepository;
import com.packs.flyy.repositories.UsersRepository;
import com.packs.flyy.security.utils.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServices {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AdminProfileRepository adminProfileRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    AgentProfileRepository agentProfileRepository;



    public ApiResponse signup(LoginReq adminLoginReq) {

        if (adminProfileRepository.existsByUsername(adminLoginReq.getUsername())) {
            return new ApiResponse(409, HttpStatus.CONFLICT, "Username already taken");
        }

        Users userObj = usersRepository.save(
                new Users(rolesRepository.findByName("ADM"))
        );

        AdminProfiles adminProfile = new AdminProfiles(
                userObj.getUserid(), adminLoginReq.getUsername(), passwordEncoder.encode(adminLoginReq.getPassword())
        );

        adminProfileRepository.save(adminProfile);

        return new ApiResponse(200, HttpStatus.OK, "Sign Up Success");
    }

    public ApiResponse login(LoginReq adminLoginReq) {
        //Use authentication manager to validate
        Authentication authentication=authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(adminLoginReq.getUsername(),adminLoginReq.getPassword())
        );

        //Generate JWT for valid user and return in response
        String jwt = tokenProvider.generateToken(authentication);
        return new ApiResponse(jwt,200,HttpStatus.OK);
    }

    public ApiResponse addAgent(LoginReq loginReq){
        if(agentProfileRepository.existsByUsername(loginReq.getUsername()))
            return new ApiResponse(409, HttpStatus.CONFLICT, "Username already taken");

        Users userObj = usersRepository.save(
                new Users(rolesRepository.findByName("CLI"))
        );

        AgentProfiles agentProfile=new AgentProfiles(userObj.getUserid(),
                loginReq.getUsername(),
                passwordEncoder.encode(loginReq.getPassword()));

        agentProfileRepository.save(agentProfile);

        return new ApiResponse(200, HttpStatus.OK, "Agent Added Successfully");
    }

}
