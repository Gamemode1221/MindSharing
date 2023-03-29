package com.spring.Repository;

import com.spring.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Test, Long> {
}