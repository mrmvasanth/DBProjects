package com.packs.ossf.services;

import com.packs.ossf.models.RegisterUserModel;
import com.packs.ossf.repositories.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        Optional<RegisterUserModel> userModel=registerRepository.findByUserid(userid);
        if(userModel.isPresent()){
            return new UserDetailsImpl(userModel.get());
        }else {
            throw new UsernameNotFoundException("User Not Found");
        }

    }
}
