package com.isolaja.catpeopleworld.entity;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    Gender gender;

    private LocalDate dateOfBirth;

    @Formula("datediff(curdate(), date_of_birth)/365")
    private int age;

    @ManyToMany(mappedBy = "cats")
    private Set<User> owners = new HashSet<>();

}
