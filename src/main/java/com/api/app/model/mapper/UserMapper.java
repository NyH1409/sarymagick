package com.api.app.model.mapper;

import com.api.app.model.HUsers;
import com.api.app.model.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public Users toDomain(HUsers entity) {
    return new Users(entity.getUsername(), entity.getPassword());
  }
}
