package com.example.spring_3_1_3_bootstrap.repositories;

import com.example.spring_3_1_3_bootstrap.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
