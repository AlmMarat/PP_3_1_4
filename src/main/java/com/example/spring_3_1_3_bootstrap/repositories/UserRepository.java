package com.spring.security.pp_3_1_2_v2.repositories;

import com.spring.security.pp_3_1_2_v2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
