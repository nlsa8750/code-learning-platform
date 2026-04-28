package com.Technick_Code.code_learning_platform.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

// isme no args all args lagane ki zaroorat nahi hai kyuki lombok compile time main args create karke jackson usi no args ka istmal kar leta hai ,setters lagata hai map karne k liye json value.
// verify karne k liye .class file dekh lena  
@Data
public class RegisterRequest {
    
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Full Name is required")
    private String fullName;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email Format")
    private String email;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;

}
