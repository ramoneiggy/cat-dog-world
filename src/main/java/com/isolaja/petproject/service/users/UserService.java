package com.isolaja.petproject.service.users;

import com.isolaja.petproject.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    void save(User user);

}
