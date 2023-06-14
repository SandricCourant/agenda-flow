package com.example.demo.repositories;

import com.example.demo.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
