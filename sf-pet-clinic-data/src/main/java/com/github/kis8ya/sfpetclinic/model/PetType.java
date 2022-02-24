package com.github.kis8ya.sfpetclinic.model;

public class PetType extends BaseEntity {

    private String name;

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
