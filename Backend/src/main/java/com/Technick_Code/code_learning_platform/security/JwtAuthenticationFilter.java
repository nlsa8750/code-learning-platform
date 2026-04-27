package com.Technick_Code.code_learning_platform.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;

@Component
// for dependency injection
@RequiredArgsConstructor
// yeh tab kar rahe hai jab jwt token generate ho jaane k baad jab response browswer k paas jaata hai phir client token leke server k paas validate hone k liye 

// http request se authorization wala request nikalne k baad agar uss request main bearer likha hua toh usme se token fetch karke phir usko validate karenge 
// agar sahi hua toh usme se username nikalke phir usse userdetails nikalenge jo springframework security handle karta hai
// waha se phir userdetails nikalke phir authenticate karenge -> jiske liye username aur userdetails chaiye
// uske woh authentication ko SecurityContextHolder main store karwa denge aur phir ab request response ready hai.
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain ) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if(authHeader != null && authHeader.startsWith("Bearer")){
            String token = authHeader.substring(7);

            if(jwtTokenProvider.validateToken(token)) {
                String username = jwtTokenProvider.getUsernameFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, userDetails);

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                
            }
        }

        filterChain.doFilter(request, response);
    }
}