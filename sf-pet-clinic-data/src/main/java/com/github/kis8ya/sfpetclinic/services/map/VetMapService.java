package com.github.kis8ya.sfpetclinic.services.map;

import com.github.kis8ya.sfpetclinic.model.Vet;
import com.github.kis8ya.sfpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class VetMapService extends AbstractMapService<Vet> implements VetService {
}
