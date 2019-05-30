package com.isolaja.petproject.model.images;

import com.isolaja.petproject.model.base.BaseImage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity(name = "pet_images")
@EqualsAndHashCode(callSuper = true)
public class PetImage extends BaseImage {
    private int petId;
}
