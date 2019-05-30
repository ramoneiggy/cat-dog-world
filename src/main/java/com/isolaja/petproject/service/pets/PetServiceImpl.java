package com.isolaja.petproject.service.pets;

import com.isolaja.petproject.model.entity.Pet;
import com.isolaja.petproject.model.enums.Animal;
import com.isolaja.petproject.repository.PetRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Cacheable("all-pets")
    @Transactional
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Cacheable("all-cats")
    public List<Pet> getAllCats() {
        List<Pet> cats = new ArrayList<>();
        for (Pet pet : getAllPets()) {
            if (pet.getAnimal().equals(Animal.CAT)) {
                cats.add(pet);
            }
        }
        return cats;
    }

    @Cacheable("all-dogs")
    public List<Pet> getAllDogs() {
        List<Pet> cats = new ArrayList<>();
        for (Pet pet : getAllPets()) {
            if (pet.getAnimal().equals(Animal.DOG)) {
                cats.add(pet);
            }
        }
        return cats;
    }

    public List<Pet> getAllCatsWithoutOwners() {
        List<Pet> catsWithoutOwners = new ArrayList<>();
        for (Pet cat : getAllCats()) {
            if (cat.getOwners().isEmpty()) {
                catsWithoutOwners.add(cat);
            }
        }
        return catsWithoutOwners;
    }

}
