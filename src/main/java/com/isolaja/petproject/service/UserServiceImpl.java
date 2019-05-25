package com.isolaja.petproject.service;

import com.isolaja.petproject.dao.UserRepository;
import com.isolaja.petproject.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable("all-users")
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersWithoutPets() {
        return getAllUsers()
                .stream()
                .filter(user -> user.getPets().isEmpty())
                .collect(Collectors.toList());
    }

}
