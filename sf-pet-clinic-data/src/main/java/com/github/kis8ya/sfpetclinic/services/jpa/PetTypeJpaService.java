package com.github.kis8ya.sfpetclinic.services.jpa;

import com.github.kis8ya.sfpetclinic.model.PetType;
import com.github.kis8ya.sfpetclinic.repositories.PetTypeRepository;
import com.github.kis8ya.sfpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("jpa")
@Service
public class PetTypeJpaService extends AbstractJpaService<PetType, PetTypeRepository> implements PetTypeService {

    public PetTypeJpaService(PetTypeRepository repository) {
        super(repository);
    }
}
