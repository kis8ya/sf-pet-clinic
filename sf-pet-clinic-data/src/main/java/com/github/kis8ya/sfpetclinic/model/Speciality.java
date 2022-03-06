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
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    private String name;
    private String description;

    public Speciality(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
