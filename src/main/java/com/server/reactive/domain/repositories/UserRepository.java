package com.server.reactive.domain.repositories;

import com.server.reactive.domain.entities.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface     UserRepository extends JpaRepository<UserCredential, Long> {
    UserCredential findByUsername(String username);
}
