package com.isolaja.petproject.model.images;

import com.isolaja.petproject.model.base.BaseImage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity(name = "user_images")
@EqualsAndHashCode(callSuper = true)
public class UserImage extends BaseImage {
    private int userId;
}
