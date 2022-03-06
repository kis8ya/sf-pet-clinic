package com.github.kis8ya.sfpetclinic.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity {

    private String name;

    public PetType(String name) {
        this.name = name;
    }

    public static PetType of(String name) {
        return new PetType(name);
    }

}
