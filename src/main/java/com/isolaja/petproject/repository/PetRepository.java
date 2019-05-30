package com.isolaja.petproject.repository;

import com.isolaja.petproject.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
