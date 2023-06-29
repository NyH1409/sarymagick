package com.api.app.repository.jpa;

import com.api.app.model.HUsers;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<HUsers, String> {
  Optional<HUsers> findByUsername(String username);
}
