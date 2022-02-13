package com.github.kis8ya.sfpetclinic.services;

import com.github.kis8ya.sfpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);
    Owner findByLastName(String lastName);
    Owner save(Owner owner);
    Set<Owner> findAll();

}
