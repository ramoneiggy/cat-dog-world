package com.isolaja.petproject.controller;

import com.isolaja.petproject.dao.PetRepository;
import com.isolaja.petproject.dao.UserRepository;
import com.isolaja.petproject.entity.Pet;
import com.isolaja.petproject.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/george") //TODO change name
public class ProjectRestController {

    private UserRepository userRepository;
    private PetRepository petRepository;

    public ProjectRestController(UserRepository userRepository, PetRepository petRepository) {
        this.userRepository = userRepository;
        this.petRepository = petRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{user-id}")
    public Optional<User> getUser(@PathVariable("user-id") int userId) {
        return userRepository.findById(userId);
    }

    @GetMapping("/pets/{pet-id}")
    public Optional<Pet> getPet(@PathVariable("pet-id") int petId) {
        return petRepository.findById(petId);
    }

}
