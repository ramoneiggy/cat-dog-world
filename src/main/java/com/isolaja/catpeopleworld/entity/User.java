package com.isolaja.catpeopleworld.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "users")
@Data
@EqualsAndHashCode(exclude = {"cats", "dogs"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String firstName;
    private String lastName;

    @JsonIgnore
    private String email;

    private LocalDate dateOfBirth;
    private LocalDateTime registrationDate;
    private String country;
    private String city;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Formula("datediff(curdate(), date_of_birth)/365")
    private int age;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "cat_owner",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cat_id", referencedColumnName = "id"))
    private Set<Cat> cats;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "dog_owner",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dog_id", referencedColumnName = "id"))
    private Set<Dog> dogs;

}
