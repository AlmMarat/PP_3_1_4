package com.spring.security.pp_3_1_2_v2.services;

import com.spring.security.pp_3_1_2_v2.entities.User;
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
