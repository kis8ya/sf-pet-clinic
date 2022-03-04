package com.github.kis8ya.sfpetclinic.services.jpa;

import com.github.kis8ya.sfpetclinic.model.Speciality;
import com.github.kis8ya.sfpetclinic.repositories.SpecialtyRepository;
import com.github.kis8ya.sfpetclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("jpa")
@Service
public class SpecialitiesJpaService extends AbstractJpaService<Speciality, SpecialtyRepository> implements SpecialtiesService {

    public SpecialitiesJpaService(SpecialtyRepository repository) {
        super(repository);
    }
}
