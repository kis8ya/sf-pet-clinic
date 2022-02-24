package com.github.kis8ya.sfpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

    private PetType type;
    private Owner owner;
    private LocalDate birthDay;
    private String name;

    public Pet(PetType type, Owner owner, LocalDate birthDay, String name) {
        this.type = type;
        this.owner = owner;
        this.birthDay = birthDay;
        this.name = name;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
