package com.desafioViaSoluti.demo.service.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenGenerator {
    private static final String SECRET_KEY = "my_secret_key";
    private static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 days

    public static String generateToken(String password) {
        return Jwts.builder()
                .setSubject(password)
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
