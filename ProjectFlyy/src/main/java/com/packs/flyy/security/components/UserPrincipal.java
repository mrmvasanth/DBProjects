package com.packs.flyy.security.components;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.packs.flyy.models.entity.Admin.AdminProfiles;
import com.packs.flyy.models.entity.Roles;
import com.packs.flyy.models.entity.Users;
import com.packs.flyy.repositories.AdminProfileRepository;
import com.packs.flyy.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {


    @Autowired
    static
    UsersRepository usersRepository;

    @Autowired
    static
    AdminProfileRepository adminProfileRepository;

    //    This is the class whose instances will be returned from our custom UserDetailsService
    private Long id;

    private String name;

    private String username;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(AdminProfiles adminProfile) {

        //to get user id from users repo to get role
        Long userid=adminProfile.getUserid();
        Optional<Users> users = usersRepository.findByUserid(userid);

        List<String> roles = Arrays.asList(users.get().getRoles().getName());

        List<GrantedAuthority> authorities = roles.stream().map(
                role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());

        return new UserPrincipal(
                adminProfile.getUserid(),
                adminProfile.getName(),
                adminProfile.getUsername(),
                adminProfile.getPassword(),
                authorities
        );
    }


    public static UserPrincipal createAdminPrinciple(AdminProfiles adminProfile, Roles rolesObj) {

        List<String> roles= Arrays.asList(rolesObj.getName());

        List<GrantedAuthority> authorities = roles.stream().map(
                role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());

        return new UserPrincipal(
                adminProfile.getUserid(),
                adminProfile.getName(),
                adminProfile.getUsername(),
                adminProfile.getPassword(),
                authorities
        );
    }



    public UserPrincipal(Long id, String name, String username, String password,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public UsersRepository getUsersRepository() {
        return usersRepository;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
