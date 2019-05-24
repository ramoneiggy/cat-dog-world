package com.isolaja.petproject.entity.images;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "user_images")
public class UserImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;

    private String fileName;

    @Column(columnDefinition = "BOOLEAN")
    private boolean isProfile;

    private LocalDateTime timestamp;

}
