package com.example.spring_3_1_3_bootstrap.services;

import com.example.spring_3_1_3_bootstrap.entities.Role;
import com.example.spring_3_1_3_bootstrap.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    public Set<Role> allRoles() {
        return new HashSet<>(roleRepository.findAll());
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public Set<Role> findById(Long[] id) {
        return roleRepository.getRolesById(id);
    }

    @Override
    public Role getRole(String name) {
        return roleRepository.findByName(name);
    }
}
