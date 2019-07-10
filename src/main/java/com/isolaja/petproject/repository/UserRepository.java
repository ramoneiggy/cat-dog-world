package com.isolaja.petproject.repository;

import com.isolaja.petproject.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
