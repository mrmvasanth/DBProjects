package com.packs.flyy.models.response;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@ToString
public class ApiResponse<T> {
    private HttpStatus httpStatus = HttpStatus.OK;
    private String message = "success";
    private T data;
    private int code = 200;
    private String accessToken;
    private String tokenType = "Bearer";


    public ApiResponse(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ApiResponse(int code,String message) {
        this.code = code;
        this.message = message;
    }


    public ApiResponse(String accessToken,int code,HttpStatus httpStatus){
        this.accessToken=accessToken;
        this.tokenType=tokenType;
        this.code=code;
        this.httpStatus=httpStatus;
    }

    //Static constructor methods
    public static <T> ApiResponse make(int code,HttpStatus httpStatus, String message) {
        return new ApiResponse(code,httpStatus, message);
    }

    public static <T> ApiResponse make(int code,String message) {
        return new ApiResponse(code,message);
    }

    public static <T> ApiResponse make(String accessToken,int code,HttpStatus httpStatus) {
        return new ApiResponse(accessToken,code,httpStatus);

    }

}
