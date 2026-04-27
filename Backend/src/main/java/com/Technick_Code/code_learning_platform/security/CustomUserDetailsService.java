package com.Technick_Code.code_learning_platform.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.Technick_Code.code_learning_platform.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ProfileRepository profileRepository;

    // pehle username verify karenge exists karta hai yah nahi.
    // agar karta hai toh tabhi uss userdetails main username assign karwa denge username main, password empty aur roles "USER" karke userdetails return kar denge.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        profileRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(">> Username not found :: "+ username));

        return User.builder().username(username).password("").roles("USER").build();
    }

}