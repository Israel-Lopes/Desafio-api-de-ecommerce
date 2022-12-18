package com.desafioViaSoluti.demo.service.token;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import javax.servlet.http.HttpServletRequest;

public class TokenVerifier {
    private static final String SECRET_KEY = "my_secret_key";

    public static boolean verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            // invalid signature
            return false;
        } catch (ExpiredJwtException e) {
            // token expired
            return false;
        }
    }
    public static Boolean tokenValidation(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return false;
        }
        return token.startsWith("Bearer ") ? true : false;
    }
}
