package com.isolaja.catpeopleworld.dao;

import com.isolaja.catpeopleworld.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Integer> {

    List<Cat> findAllByOrderByNameAsc();
}
