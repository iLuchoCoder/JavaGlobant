package com.hermes.msg.security;

import com.hermes.msg.exceptions.HermesAppExeption;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-milliseconds}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date actualDate = new Date();
        Date expirationDate = new Date(actualDate.getTime()+jwtExpirationInMs);

        String token = Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();

        return token;
    }

    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token).getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            throw new HermesAppExeption(HttpStatus.BAD_REQUEST,"Sign JWT not valid");
        }
        catch (MalformedJwtException ex){
            throw new HermesAppExeption(HttpStatus.BAD_REQUEST,"Token JWT not valid");
        }
        catch (ExpiredJwtException ex){
            throw new HermesAppExeption(HttpStatus.BAD_REQUEST,"Token JWT expired");
        }
        catch (UnsupportedJwtException ex){
            throw new HermesAppExeption(HttpStatus.BAD_REQUEST,"Token JWT not supported");
        }
        catch (IllegalArgumentException ex){
            throw new HermesAppExeption(HttpStatus.BAD_REQUEST,"The JWT Claims string is empty");
        }
    }
}
