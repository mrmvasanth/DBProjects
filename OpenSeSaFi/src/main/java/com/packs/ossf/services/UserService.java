package com.packs.ossf.services;

import com.packs.ossf.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
