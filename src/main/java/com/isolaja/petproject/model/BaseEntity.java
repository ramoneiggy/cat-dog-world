package com.isolaja.petproject.model;

import com.isolaja.petproject.model.enums.Gender;
import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dateOfBirth;

    private LocalDateTime registrationDate;

    @Formula("datediff(curdate(), date_of_birth)/365")
    private int age;
}
