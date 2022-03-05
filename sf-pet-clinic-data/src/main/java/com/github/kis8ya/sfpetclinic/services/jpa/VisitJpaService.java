package com.github.kis8ya.sfpetclinic.services.jpa;

import com.github.kis8ya.sfpetclinic.model.Visit;
import com.github.kis8ya.sfpetclinic.repositories.VisitRepository;
import com.github.kis8ya.sfpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("jpa")
@Service
public class VisitJpaService extends AbstractJpaService<Visit, VisitRepository> implements VisitService {

    public VisitJpaService(VisitRepository repository) {
        super(repository);
    }
}
