package com.isolaja.petproject.rest.controller;

import com.isolaja.petproject.model.entity.Pet;
import com.isolaja.petproject.model.entity.User;
import com.isolaja.petproject.repository.PetRepository;
import com.isolaja.petproject.repository.UserRepository;
import com.isolaja.petproject.service.pets.PetService;
import com.isolaja.petproject.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectRestController {

    private UserRepository userRepository;
    private PetRepository petRepository;
    private PetService petService;
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{user-id}")
    public Optional<User> getUser(@PathVariable("user-id") int userId) {
        return userRepository.findById(userId);
    }

    @PostMapping("/users/save")
    public User saveNewUser(@RequestBody User user) {
        userService.save(user);
        return user;
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
