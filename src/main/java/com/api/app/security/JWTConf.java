package com.api.app.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JWTConf implements Serializable {
  private static final long serialVersionUID = 1L;
  private static final long TOKEN_VALIDITY = 5 * 60 * 60;
  @Value("${jwt.secret.key}")
  private String secretKey;

  public String getUsernameByToken(String token) {
    return getClaimByToken(token, Claims::getSubject);
  }

  public Date getExpirationDate(String token) {
    return getClaimByToken(token, Claims::getExpiration);
  }

  private <T> T getClaimByToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsByToken(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaimsByToken(String token) {
    return Jwts.parser().setSigningKey(secretKey)
        .parseClaimsJws(token)
        .getBody();
  }

  private boolean isTokenExpired(String token) {
    Date currenExepiration = getExpirationDate(token);
    return currenExepiration.before(new Date());
  }


  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
  }

  public boolean validateToken(String token) {
    return !isTokenExpired(token);
  }
}
