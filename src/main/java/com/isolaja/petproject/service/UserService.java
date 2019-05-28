package com.isolaja.petproject.service;

import com.isolaja.petproject.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

}
