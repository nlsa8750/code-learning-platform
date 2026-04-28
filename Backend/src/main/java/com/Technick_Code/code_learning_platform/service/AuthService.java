package com.Technick_Code.code_learning_platform.service;

import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.Technick_Code.code_learning_platform.dto.request.LoginRequest;
import com.Technick_Code.code_learning_platform.dto.request.RegisterRequest;
import com.Technick_Code.code_learning_platform.dto.response.AuthResponse;
import com.Technick_Code.code_learning_platform.entity.Profile;
import com.Technick_Code.code_learning_platform.exception.UnauthorizedException;
import com.Technick_Code.code_learning_platform.exception.UserAlreadyExistsException;
import com.Technick_Code.code_learning_platform.repository.ProfileRepository;
import com.Technick_Code.code_learning_platform.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ProfileRepository profileRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if(profileRepository.findByUsername(request.getUsername()) == null) {
            throw new UserAlreadyExistsException("User is already taken");
        }

        Profile profile = new Profile();
        profile.setId(UUID.randomUUID());
        profile.setUsername(request.getUsername());
        profile.setFullName(request.getFullName());
        profile.setCurrentStreak(0);
        profile.setMaxStreak(0);

        profileRepository.save(profile);

        String token = jwtTokenProvider.generateToken(profile.getUsername());

        return new AuthResponse(token,profile.getUsername(),profile.getId());

    }

    public AuthResponse login(LoginRequest request) {

        // authenticationManager -> userDetailsService -> overridden loadsUserByUsername function -> validate username and password(bcrypt) in db
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new UnauthorizedException("Invalid Credentials");
        }

        String token = jwtTokenProvider.generateToken(request.getUsername());

        Profile profile = profileRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        return new AuthResponse(token, profile.getUsername(), profile.getId());

    }
}