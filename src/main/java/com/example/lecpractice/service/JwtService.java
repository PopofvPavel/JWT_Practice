package com.example.lecpractice.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "QWERTYUIOPASDFGHJKLZXCVBNMSECRETKEYQWERTYUIOPASDFGHJKLZXCVBNMQWER" +
            "TYUIOPASDFGHJKLZXCVBNMSECRETKEYQWERTYUIOPASDFGHJKLZXCVBNM";
    private static final long EXPIRATION_TIME = 864_000_000;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }


}
