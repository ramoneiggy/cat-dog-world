package com.isolaja.petproject.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity(name = "pet_images")
public class PetImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int petId;

    private String fileName;

    @Column(columnDefinition = "BOOLEAN")
    private boolean isProfile;

    private LocalDateTime timestamp;

}
