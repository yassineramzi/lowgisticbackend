package com.lowgistic.gateway.helper;

import com.lowgistic.gateway.domain.Role;
import com.lowgistic.gateway.domain.User;
import com.lowgistic.gateway.security.exception.JwtAuthenticationException;
import com.lowgistic.gateway.security.exception.JwtExpiredTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${lowgistic.app.jwtSecret}")
    private String jwtSecret;

    @Value("${lowgistic.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);

    public Claims getAllClaimsFromToken(String token) {
            try {
                return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody();
            } catch (ExpiredJwtException ex) {
                throw new JwtExpiredTokenException("JWT token has expired");
            } catch (Exception ex) {
                throw new JwtAuthenticationException("JWT token validation failed");
            }
    }

    public String getUsernameFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public List<String> getRolesFromToken(String token) {
        return (List<String>)getAllClaimsFromToken(token).get("roles");
    }

    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", user.getRoles().stream().map(Role::getNomRole).collect(Collectors.toList()));
        return doGenerateToken(claims, user.getEmail());
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    private String doGenerateToken(Map<String, Object> claims, String username) {
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
}
