package com.github.kis8ya.sfpetclinic.services.jpa;

import com.github.kis8ya.sfpetclinic.model.Vet;
import com.github.kis8ya.sfpetclinic.repositories.VetRepository;
import com.github.kis8ya.sfpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("jpa")
@Service
public class VetJpaService extends AbstractJpaService<Vet, VetRepository> implements VetService {

    public VetJpaService(VetRepository repository) {
        super(repository);
    }
}
