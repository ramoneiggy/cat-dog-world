package com.isolaja.petproject.service;

import com.isolaja.petproject.model.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getAllPets();

    List<Pet> getAllCats();

    List<Pet> getAllDogs();

    List<Pet> getAllCatsWithoutOwners();

}
