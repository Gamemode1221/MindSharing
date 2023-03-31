package com.spring.Repository;

import com.spring.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Test, Long> {
    Optional<Test> findByname(String name);
}