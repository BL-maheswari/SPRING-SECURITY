package com.bl.jwtauthentication.security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys; // NEW IMPORT
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key; // NEW IMPORT
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Base64; // Might need this if your secret string is truly Base64 encoded bytes

@Component
public class JwtHelper {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60; // 5 hours

    // Your secret string. Ensure it's long enough and strong.
    // For HS512, it should ideally be 512 bits (64 bytes) long when base64 decoded.
    final private String secretString = "afafasfafafasfasfasfafafafawefasfacacsafafasfafafasfasfasfafafafawefasfacac"; // This string is 64 characters long, so it's 64 bytes.

    // Derive a proper Key object from your secret string once
    private final Key secretKey;

    public JwtHelper() {
        // It's crucial to correctly derive the key for HMAC.
        // Assuming your 'secretString' is a plain string that needs to be treated as bytes for HMAC.
        // If your 'secretString' is already a Base64-encoded version of your actual secret bytes,
        // you would first Base64.getDecoder().decode(secretString).
        byte[] keyBytes = secretString.getBytes(); // Convert string to bytes
        this.secretKey = Keys.hmacShaKeyFor(keyBytes); // Use Keys.hmacShaKeyFor for proper Key generation
    }

    // Retrieve username from jwt token
    public String getUserNameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    // retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken (token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // for retrieving any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        // Use the generated secretKey here for parsing as well
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }

    // check if the token has expired
    private Boolean isTokenExperied(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // generate token for user
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims,userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY * 1000))
                // Change to an HMAC algorithm (e.g., HS512) and use the generated 'secretKey'
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    // Validate token
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExperied(token));
    }
}
