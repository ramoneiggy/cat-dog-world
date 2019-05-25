package com.isolaja.petproject.service;

import com.isolaja.petproject.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> getUsersWithoutPets();

}
