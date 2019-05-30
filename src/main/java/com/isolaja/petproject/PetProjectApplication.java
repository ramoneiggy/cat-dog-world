package com.isolaja.petproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PetProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetProjectApplication.class, args);
    }
}
