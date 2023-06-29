package com.api.app.security;

import com.api.app.controller.restmodel.Users;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Whoami {
  private String accessToken;
  private Date expiresIn;
  private Users users;
}
