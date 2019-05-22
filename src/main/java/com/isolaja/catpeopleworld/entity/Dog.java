package com.isolaja.catpeopleworld.entity;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "dogs")
@Data
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    Gender gender;

    private LocalDate dateOfBirth;

    @Formula("datediff(curdate(), date_of_birth)/365")
    private int age;

    private LocalDateTime registrationDate;
    private String country;
    private String city;
    private String breed;

    @ManyToMany(mappedBy = "dogs")
    private Set<User> owners = new HashSet<>();

}
