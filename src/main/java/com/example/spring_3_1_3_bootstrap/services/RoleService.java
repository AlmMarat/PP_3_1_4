package com.example.spring_3_1_3_bootstrap.services;

import com.example.spring_3_1_3_bootstrap.entities.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> allRoles();
    Role findByName(String name);
    void save(Role role);
    Role findById(Long id);
    Role getRole(String name);
    public void addRole(Role role);
}
