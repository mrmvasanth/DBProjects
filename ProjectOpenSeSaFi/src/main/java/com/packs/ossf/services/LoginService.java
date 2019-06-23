package com.packs.ossf.services;

import com.packs.ossf.models.LoginModel;
import com.packs.ossf.models.RegisterUserModel;
import com.packs.ossf.repositories.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    RegisterRepository registerRepository;

    public String registerUser(RegisterUserModel registerUser){


        registerRepository.save(registerUser);
        return "Registration Success";
    }

    public String login(LoginModel loginModel) throws Exception {
        Optional<RegisterUserModel> userList= registerRepository.findByUserid(loginModel.getUsername());
        if(userList.isPresent()){
            if(userList.get().getPassword().equals(loginModel.getPassword())){
                return "Logged In";
            }else {
                throw new Exception("Invalid Password");
            }
        }else{
            throw new Exception("User Not Found");
        }
    }
}
