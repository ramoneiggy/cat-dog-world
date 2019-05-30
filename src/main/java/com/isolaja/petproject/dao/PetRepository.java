package com.isolaja.petproject.dao;

import com.isolaja.petproject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
