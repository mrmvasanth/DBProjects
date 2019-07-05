package com.packs.flyy.security.services;

import com.packs.flyy.constants.MessageConstants;
import com.packs.flyy.models.entity.Admin.AdminProfiles;
import com.packs.flyy.models.entity.Roles;
import com.packs.flyy.models.entity.Users;
import com.packs.flyy.repositories.AdminProfileRepository;
import com.packs.flyy.repositories.RolesRepository;
import com.packs.flyy.repositories.UsersRepository;
import com.packs.flyy.security.components.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdminDetailisService implements UserDetailsService {
    @Autowired
    AdminProfileRepository adminProfileRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UsersRepository usersRepository;

    //    Returns UserPrincipal object for the given username
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdminProfiles adminProfiles = adminProfileRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(MessageConstants.USER_NOT_FOUND + username)
        );
        Roles roles= getRoles(adminProfiles.getUserid());
        return UserPrincipal.createAdminPrinciple(adminProfiles,roles);

    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserPrincipal loadAdminProfileByuser_id(Long userid) {
        AdminProfiles adminProfiles=adminProfileRepository.findByUserid(userid).orElseThrow(
                () -> new UsernameNotFoundException(MessageConstants.USER_NOT_FOUND + userid)
        );
        Roles roles= getRoles(adminProfiles.getUserid());
        return UserPrincipal.createAdminPrinciple(adminProfiles,roles);
    }

    private Roles getRoles(Long userid){
        Optional<Users> user=usersRepository.findByUserid(userid);
        return user.get().getRoles();
    }


}
