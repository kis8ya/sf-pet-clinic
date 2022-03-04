package com.github.kis8ya.sfpetclinic.repositories;

import com.github.kis8ya.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
