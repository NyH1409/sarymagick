package com.api.app.security;

import com.api.app.controller.restmodel.Users;
import com.api.app.service.UserService;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthProvider {
  private UserService userService;
  private JWTConf jwtConf;
  private AuthenticationManager authenticationManager;

  public Whoami authenticateUser(Principal principal) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(principal.getUsername(),
              principal.getPassword()));
    } catch (UsernameNotFoundException e) {
      throw new UsernameNotFoundException("User not found");
    }
    UserDetails auth = userService.loadUserByUsername(principal.getUsername());
    String token = jwtConf.generateToken(auth);
    Date expiration = jwtConf.getExpirationDate(token);
    return Whoami.builder()
        .users(new Users(auth.getUsername()))
        .accessToken(token)
        .expiresIn(expiration)
        .build();
  }

}
