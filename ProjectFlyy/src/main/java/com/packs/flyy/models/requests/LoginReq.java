package com.packs.flyy.models.requests;

import javax.validation.constraints.NotBlank;

public class LoginReq {
    @NotBlank
    public String username;

    @NotBlank
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
