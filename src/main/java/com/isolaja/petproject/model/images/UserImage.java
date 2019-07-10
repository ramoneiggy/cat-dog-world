package com.isolaja.petproject.model.images;

import com.isolaja.petproject.model.base.AbstractBaseImage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity(name = "user_images")
@EqualsAndHashCode(callSuper = true)
public class UserImage extends AbstractBaseImage {
    private int userId;
}
