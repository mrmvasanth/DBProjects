package com.packs.flyy.models.response;

import com.packs.flyy.models.entity.Users;
import com.packs.flyy.models.entity.UsersProfiles;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Optional;


@Getter
@Setter
@ToString
public class ApiResponse<T> {
    private HttpStatus httpStatus = HttpStatus.OK;
    private String message = "success";
    private T data;
    private int code = 200;

    public ApiResponse(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ApiResponse(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(Optional<UsersProfiles> user) {
        this.data= (T) user;
    }

    public ApiResponse(Users user) {
    }

    //Static constructor methods
    public static <T> ApiResponse make(int code,HttpStatus httpStatus, String message) {
        return new ApiResponse(code,httpStatus, message);
    }

    public static <T> ApiResponse make(int code,String message) {
        return new ApiResponse(code,message);
    }

    public static ApiResponse make(Optional<UsersProfiles> user){
        return new ApiResponse(user);
    }


}
