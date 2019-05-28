package com.isolaja.petproject.controller;

import com.isolaja.petproject.entity.Pet;
import com.isolaja.petproject.service.PetServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private PetServiceImpl petService;

    public ProjectController(PetServiceImpl petService) {
        this.petService = petService;
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
