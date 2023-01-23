package com.qaa.model.security;


import com.qaa.api.users.vo.UserVo;
import io.jsonwebtoken.*;
import jakarta.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.function.Function;

/**
 * @author Mahesh
 */
@Component
public class JWTUtil {
    @Value("${security.jwt.secret}")
    private String key;

    @Value("${security.jwt.issuer}")
    private String issuer;

    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;

    private final Logger log = LoggerFactory
            .getLogger(JWTUtil.class);

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    
    /**
     * Create a new token.
     *
     * @param id
     * @param subject
     * @return
     */
    public String create(UserVo user) {

        // The JWT signature algorithm used to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //  sign JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //  set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(user.getId().toString()).setIssuedAt(now).setSubject(user.getUsername()).setIssuer(issuer)
                .claim("roles", user.getUserRoles().toString()).signWith(signingKey,signatureAlgorithm);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public boolean validateToken(String token) throws Exception {
        try{
            Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            throw new Exception("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new Exception("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new Exception("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new Exception("JWT claims string is empty.");
        }
    }


    /**
     * Method to validate and read the JWT
     *
     * @param jwt
     * @return
     */
    public String getSubject(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as
        // expected)
        Claims claims = Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build().parseClaimsJws(jwt).getBody();

        return claims.getSubject();
    }


    /**
     * Method to validate and read the JWT
     *
     * @param jwt
     * @return
     */
    public String getKey(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as
        // expected)
        Claims claims = Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build().parseClaimsJws(jwt).getBody();

        return claims.getId();
    }
}