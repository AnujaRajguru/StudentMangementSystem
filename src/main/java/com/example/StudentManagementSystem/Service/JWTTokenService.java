package com.example.StudentManagementSystem.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTokenService {
    private final String private_key = "my_secret_key";

    public String generateJWTToken(String username,String role){
        return Jwts
                .builder()
                .setSubject(username)
                .claim("role",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 36000000))
                .signWith(SignatureAlgorithm.HS256,private_key)
                .compact();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(private_key).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String extractUsername(String tokne){
        return Jwts.parser().setSigningKey(private_key).parseClaimsJws(tokne).getBody().getSubject();
    }

    public String extractRole(String tokne){
        return Jwts.parser()
                .setSigningKey(private_key)
                .parseClaimsJws(tokne)
                .getBody()
                .get("role", String.class);
    }
}
