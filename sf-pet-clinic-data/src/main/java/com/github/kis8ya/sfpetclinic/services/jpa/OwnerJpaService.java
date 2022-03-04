package com.github.kis8ya.sfpetclinic.services.jpa;

import com.github.kis8ya.sfpetclinic.model.Owner;
import com.github.kis8ya.sfpetclinic.model.Pet;
import com.github.kis8ya.sfpetclinic.repositories.OwnerRepository;
import com.github.kis8ya.sfpetclinic.services.OwnerService;
import com.github.kis8ya.sfpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("jpa")
@Service
public class OwnerJpaService extends AbstractJpaService<Owner, OwnerRepository> implements OwnerService {

    private final PetService petService;

    public OwnerJpaService(OwnerRepository repository, PetService petService) {
        super(repository);
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object) {
        if (object == null) {
            return null;
        }
        if (object.getPets() != null) {
            for (Pet pet : object.getPets()) {
                petService.save(pet);
            }
        }
        return repository.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

}
