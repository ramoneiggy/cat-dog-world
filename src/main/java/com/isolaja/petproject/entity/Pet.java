package com.isolaja.petproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isolaja.petproject.entity.images.PetImage;
import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Animal animal;

    private String breed;

    @Enumerated(EnumType.STRING)
    Gender gender;

    private LocalDate dateOfBirth;

    private LocalDateTime registrationDate;

    private String description;

    private int addedByUser;

    @Formula("datediff(curdate(), date_of_birth)/365")
    private int age;

    // image handling
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List<PetImage> petImages = new ArrayList<>();

    // database mapping
    @JsonIgnoreProperties("pets")
    @ManyToMany(mappedBy = "pets")
    private Set<User> owners = new HashSet<>();

}
