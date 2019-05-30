package com.isolaja.petproject.model.base;

import com.isolaja.petproject.model.enums.Gender;
import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "gender.empty")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotEmpty
    @Past(message = "birth.date.fail")
    private LocalDate dateOfBirth;

    private LocalDateTime registrationDate;

    @Formula("datediff(curdate(), date_of_birth)/365")
    private int age;
}
