package com.packs.ossf.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
