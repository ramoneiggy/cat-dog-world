package com.isolaja.catpeopleworld.dao;

import com.isolaja.catpeopleworld.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
