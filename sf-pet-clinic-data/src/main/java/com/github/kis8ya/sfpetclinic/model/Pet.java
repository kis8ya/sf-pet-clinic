package com.github.kis8ya.sfpetclinic.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "type_id")
    private PetType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    private LocalDate birthDay;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    @OrderBy("date ASC")
    private Set<Visit> visits;

    public Pet(PetType type, Owner owner, LocalDate birthDay, String name) {
        this.type = type;
        this.owner = owner;
        this.birthDay = birthDay;
        this.name = name;
    }

}
