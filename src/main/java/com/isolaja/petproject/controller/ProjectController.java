package com.isolaja.petproject.controller;

import com.isolaja.petproject.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private UserService userService;

    public ProjectController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Map<Integer, String> getAllUserNames() {
        return userService.getAllUsers();
    }
}
