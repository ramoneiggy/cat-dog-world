package com.isolaja.petproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isolaja.petproject.model.base.BaseEntity;
import com.isolaja.petproject.model.images.UserImage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "users")
@EqualsAndHashCode(exclude = {"pets"}, callSuper = true)
public class User extends BaseEntity {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String country;

    private String city;

    @JsonIgnore
    private String password;

    // image handling
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List<UserImage> userImages = new ArrayList<>();

    // role handling
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles = new ArrayList<>();

    // pet ownership handling
    @JsonIgnoreProperties("owners")
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "pet_owner",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id", referencedColumnName = "id"))
    private Set<Pet> pets = new HashSet<>();

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.getOwners().add(this);
    }

    private void removePet(Pet pet) {
        pets.remove(pet);
        pet.getOwners().remove(this);
    }

    public void remove() {
        for (Pet pet : new ArrayList<>(pets)) {
            removePet(pet);
        }
    }

}
