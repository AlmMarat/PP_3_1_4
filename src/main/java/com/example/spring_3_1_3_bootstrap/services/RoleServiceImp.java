package com.spring.security.pp_3_1_2_v2.services;

import com.spring.security.pp_3_1_2_v2.entities.Role;
import com.spring.security.pp_3_1_2_v2.repositories.RoleRepository;
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


}
