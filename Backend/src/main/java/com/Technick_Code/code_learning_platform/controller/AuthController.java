package com.Technick_Code.code_learning_platform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Technick_Code.code_learning_platform.dto.response.ApiResponse;
import com.Technick_Code.code_learning_platform.dto.response.AuthResponse;
import com.Technick_Code.code_learning_platform.dto.request.LoginRequest;
import com.Technick_Code.code_learning_platform.dto.request.RegisterRequest;
import com.Technick_Code.code_learning_platform.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @RequestMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("User Registered Successfully",authService.register(request)));
    }

    @RequestMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(ApiResponse.success("User Logged in successfully", authService.login(request)));
    }

}