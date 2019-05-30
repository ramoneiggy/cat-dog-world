package com.isolaja.petproject.service.pets;

import com.isolaja.petproject.model.entity.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getAllPets();

    List<Pet> getAllCats();

    List<Pet> getAllDogs();

    List<Pet> getAllCatsWithoutOwners();

}
