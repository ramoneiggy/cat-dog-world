package com.isolaja.petproject.rest.controller;

import com.isolaja.petproject.model.entity.Pet;
import com.isolaja.petproject.model.entity.User;
import com.isolaja.petproject.repository.PetRepository;
import com.isolaja.petproject.repository.UserRepository;
import com.isolaja.petproject.service.pets.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectRestController {

    private UserRepository userRepository;
    private PetRepository petRepository;
    private PetService petService;

    public ProjectRestController(UserRepository userRepository, PetRepository petRepository, PetService petService) {
        this.userRepository = userRepository;
        this.petRepository = petRepository;
        this.petService = petService;
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

    @GetMapping("/cats")
    public List<Pet> getAllCats() {
        return petService.getAllCats();
    }

    @GetMapping("/cats-without-owners")
    public List<Pet> getAllCatsWithoutOwners() {
        return petService.getAllCatsWithoutOwners();
    }
}
