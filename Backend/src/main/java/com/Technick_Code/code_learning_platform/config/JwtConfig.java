package com.Technick_Code.code_learning_platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;

@Component
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.refresh-expiration}")
    private Long refreshExpiration;

    private SecretKey getSigningKey() {
        byte [] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //access token
    public String generateToken(String username) {
        return Jwts.builder().
        subject(username).
        issuedAt(new Date()).
        expiration(new Date(System.currentTimeMillis() + expiration)).
        signWith(getSigningKey()).
        compact();

    }

    // refresh token
    public String generateRefreshToken(String username) {
        return Jwts.builder().
        subject(username).
        issuedAt(new Date()).
        expiration(new Date(System.currentTimeMillis() + refreshExpiration)).
        signWith(getSigningKey()).
        compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().
        verifyWith(getSigningKey()).
        build().
        parseSignedClaims(token).
        getPayload().
        getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().
            verifyWith(getSigningKey()).
            build().
            parseSignedClaims(token);
        } catch (Exception e) {
            return false;
        } 
        return true;
    }


}
