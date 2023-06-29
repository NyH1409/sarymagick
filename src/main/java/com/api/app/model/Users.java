package com.api.app.model;

import java.util.ArrayList;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.userdetails.User;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Users extends User {
  private String username;
  private String password;

  public Users(String username, String password) {
    super(username, password, new ArrayList<>());
    this.username = username;
    this.password = password;
  }
}
