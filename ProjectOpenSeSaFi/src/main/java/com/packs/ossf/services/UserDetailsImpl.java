package com.packs.ossf.services;

import com.packs.ossf.models.RegisterUserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {


    private RegisterUserModel registerUserModel;

    public UserDetailsImpl(RegisterUserModel registerUserModel) {
        super();
        this.registerUserModel = registerUserModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.singleton(new SimpleGrantedAuthority("USERS"));

    }

    @Override
    public String getPassword() {
        return registerUserModel.getPassword();
    }

    @Override
    public String getUsername() {
        return registerUserModel.getUserid();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
