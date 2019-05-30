package com.isolaja.petproject.dao;

import com.isolaja.petproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByName(String theRoleName);
}
