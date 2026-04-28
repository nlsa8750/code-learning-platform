package com.Technick_Code.code_learning_platform.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// general wrapper for all api response 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T>{

    private boolean success;
    private String message;
    private T data;

    // success (T data)
    public static <T>ApiResponse<T> success(T data) {
        return new ApiResponse<>(true,"Success",data);
    }

    public static <T>ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true,message,data);
    }

    // error
    public static <T>ApiResponse<T> error(T data) {
        return new ApiResponse<>(false,"Error",null);
    }

}