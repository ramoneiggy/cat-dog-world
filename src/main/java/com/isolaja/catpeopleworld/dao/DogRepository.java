package com.isolaja.catpeopleworld.dao;

import com.isolaja.catpeopleworld.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Integer> {

    List<Dog> findAllByOrderByNameAsc();
}
