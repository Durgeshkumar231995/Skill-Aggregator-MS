package com.cts.empower.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtil {

	private String secretKey = "skillaggregator"; 

    public Map<String,String> generateToken(String email) {
      
        String jwtToken = Jwts.builder().setSubject(email)
        	    .setIssuedAt(new Date(0)).signWith(SignatureAlgorithm.HS256, secretKey).compact();
        	    
        	    Map<String, String> token = new HashMap<String, String>();
        	    token.put("token", jwtToken);
        	    return token;

    }

    public String extractEmail(String token) {
        return extractClaims(token).getSubject();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String email) {
        return (email.equals(extractEmail(token)) && !isTokenExpired(token));
    }
	}

