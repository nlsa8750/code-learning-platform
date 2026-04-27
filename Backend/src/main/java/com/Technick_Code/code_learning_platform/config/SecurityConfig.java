package com.Technick_Code.code_learning_platform.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Bean;
import com.Technick_Code.code_learning_platform.security.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity 
@RequiredArgsConstructor
// csrf disable karke , session ko stateless bana rahe hai kyuki mujhe data server main store nahi karwa raha
// mentioned kare huye api main authentication nahi karr rahe par jisme main kar rahe hai 
// usme jwt ki filtering laga rakhi hai taaki api ka route protected rahe jab bhi api ko call kare
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        // disable kyuki hum manually authorization header bhejenge JWT implement karenge , na ki traditional website ki tarah cookies main store karwayenge,
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST,"/api/auth/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/problems/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/sheets/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/topics/**").permitAll()
                .anyRequest().authenticated()
            ).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
            return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

}


