package com.packs.flyy.services;

import com.packs.flyy.models.entity.UsersProfiles;
import com.packs.flyy.models.response.ApiResponse;
import com.packs.flyy.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public ApiResponse addUser(UsersProfiles user) {
        try {
            usersRepository.save(user);
        }catch (TransactionSystemException e) {
            return new ApiResponse(400, "Bad Request - Check JSON Data ");
        }
        return new ApiResponse(200, "Added User");
    }

    public ApiResponse getUser(Long userid) {
        Optional<UsersProfiles> user = usersRepository.findById(userid);
        if (user.isPresent())
            return new ApiResponse(user);
        else
            return new ApiResponse(404, "No user found");
    }

    public ApiResponse deleteUser(Long userid) {
        try {
            usersRepository.deleteById(userid);
            return new ApiResponse(200, "Deletion Success");
        } catch (EmptyResultDataAccessException e) {
            return new ApiResponse(404, "No user found");
        }

    }
}
