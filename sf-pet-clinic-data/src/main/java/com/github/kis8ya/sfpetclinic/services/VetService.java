package com.github.kis8ya.sfpetclinic.services;

import com.github.kis8ya.sfpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();

}
