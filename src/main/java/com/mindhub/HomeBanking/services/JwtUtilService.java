package com.mindhub.HomeBanking.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtilService {

    private static final String SECRET_KEY = "tu_clave_secreta"; // Cambia esto por una clave segura
    private static final long EXPIRATION_TIME = 86400000; // 24 horas en milisegundos

    // Método privado para obtener la clave secreta como un objeto Key
    private static Key getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSecretKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public Boolean isTokenExpired(String token) {
        try {
            return extractExpiration(token).before(new Date());
        } catch (Exception e) {
            return true; // Manejar excepciones al validar la expiración del token
        }
    }

    // Método privado para extraer todos los claims del token
    private Claims extractAllClaims(String token) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getSecretKey()).build().parseClaimsJws(token);
        return claimsJws.getBody();
    }
}