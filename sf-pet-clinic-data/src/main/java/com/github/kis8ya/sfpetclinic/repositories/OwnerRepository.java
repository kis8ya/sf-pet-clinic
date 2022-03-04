package com.github.kis8ya.sfpetclinic.repositories;

import com.github.kis8ya.sfpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
