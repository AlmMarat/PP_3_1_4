package com.example.spring_3_1_3_bootstrap.services;

import com.example.spring_3_1_3_bootstrap.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findById(Long id);
    List<User> findAll();
    void saveUser(User user);
    void deleteById(Long id);
    User findByUser(String name);
    void updateUser(User user);
}
