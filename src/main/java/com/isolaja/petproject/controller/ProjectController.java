package com.isolaja.petproject.controller;

import com.isolaja.petproject.entity.Pet;
import com.isolaja.petproject.entity.User;
import com.isolaja.petproject.service.PetServiceImpl;
import com.isolaja.petproject.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private UserService userService;
    private PetServiceImpl petService;

    public ProjectController(UserService userService, PetServiceImpl petService) {
        this.userService = userService;
        this.petService = petService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users-without-pets")
    public List<User> getUsersWithoutPets() {
        return userService.getUsersWithoutPets();
    }

    @GetMapping("/cats")
    public List<Pet> getAllCats() {
        return petService.getAllCats();
    }

    @GetMapping("/cats-without-owners")
    public List<Pet> getAllCatsWithoutOwners() {
        return petService.getAllCatsWithoutOwners();
    }

}
