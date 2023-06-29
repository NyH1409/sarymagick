package com.api.app.controller;

import com.api.app.security.AuthProvider;
import com.api.app.security.Principal;
import com.api.app.security.Whoami;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticateController {
  private AuthProvider authProvider;

  @PostMapping("/whoami")
  public Whoami authenticate(@RequestBody Principal principal) {
    return authProvider.authenticateUser(principal);
  }
}
