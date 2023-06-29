package com.api.app.repository;

import com.api.app.model.Users;

public interface UserRepository {
  Users findByUsername(String username);
}
