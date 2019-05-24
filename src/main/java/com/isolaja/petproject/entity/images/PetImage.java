package com.isolaja.petproject.entity.images;

import lombok.Data;

import javax.persistence.*;
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
