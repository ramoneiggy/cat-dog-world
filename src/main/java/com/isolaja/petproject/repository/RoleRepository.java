package com.isolaja.petproject.repository;

import com.isolaja.petproject.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByName(String theRoleName);
}
