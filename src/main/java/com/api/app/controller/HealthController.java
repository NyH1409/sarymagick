package com.api.app.controller;

import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HealthController {

  @GetMapping("/ping")
  public String ping(HttpServletRequest request) {
    return "pong";
  }

}
