package com.github.kis8ya.sfpetclinic.services.jpa;

import com.github.kis8ya.sfpetclinic.model.Pet;
import com.github.kis8ya.sfpetclinic.repositories.PetRepository;
import com.github.kis8ya.sfpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("jpa")
@Service
public class PetJpaService extends AbstractJpaService<Pet, PetRepository> implements PetService {

    public PetJpaService(PetRepository repository) {
        super(repository);
    }
}
