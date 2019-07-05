package com.packs.flyy.security.utils;

import com.packs.flyy.security.components.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    //    This class will be used for generating a JWT after a user logs in successfully,
    //    and also validating the JWT sent in the Authorization header of the requests

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    @Value("${app.jwtSecret}")
    private String jwtSecret;

//    @Value("${app.jwtExpirationInMs}")
//    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        Map<String, Object> jwtMap = new HashMap<>();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        //To get role
        Object[] rolesArr = authentication.getAuthorities().toArray();
        String role=rolesArr[0].toString();

//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        jwtMap.put("userId",userPrincipal.getId());
        jwtMap.put("role",role);
        jwtMap.put("username",userPrincipal.getUsername());

        String token = Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
//                .setClaims(jwtMap)
//                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        return token;
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        System.out.println("=>"+claims.getSubject());
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
