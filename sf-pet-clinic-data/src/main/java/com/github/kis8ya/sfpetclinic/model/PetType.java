package com.github.kis8ya.sfpetclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity {

    private String name;

    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }

    public static PetType of(String name) {
        return new PetType(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
