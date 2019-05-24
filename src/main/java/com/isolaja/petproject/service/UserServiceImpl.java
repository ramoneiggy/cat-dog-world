package com.isolaja.petproject.service;

import com.isolaja.petproject.dao.UserRepository;
import com.isolaja.petproject.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Map<Integer, String> getAllUsers() {

        Map<Integer, String> userNames = new HashMap<>();

        for (User user : userRepository.findAll()) {
            userNames.put(user.getId(), user.getUsername());
        }

        return userNames;
    }

}
