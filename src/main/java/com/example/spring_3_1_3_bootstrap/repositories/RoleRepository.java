package com.example.spring_3_1_3_bootstrap.repositories;

import com.example.spring_3_1_3_bootstrap.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Override
    List<Role> findAll();

    Role findByName(String name);

    @Query(value = "SELECT r FROM Role r WHERE r.id in :id")
    Set<Role> getRolesById(@Param("id") Long id);


}