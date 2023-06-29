package com.api.app.repository.implementation;

import com.api.app.model.Users;
import com.api.app.model.mapper.UserMapper;
import com.api.app.repository.UserRepository;
import com.api.app.repository.jpa.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
  private final UserJpaRepository jpaRepository;
  private final UserMapper mapper;

  @Override
  public Users findByUsername(String username) {
    return mapper.toDomain(jpaRepository.findByUsername(username)
        .orElseThrow());
  }
}
