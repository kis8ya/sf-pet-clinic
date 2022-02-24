package com.github.kis8ya.sfpetclinic.services.map;

import com.github.kis8ya.sfpetclinic.model.Pet;
import com.github.kis8ya.sfpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class PetMapService extends AbstractMapService<Pet> implements PetService {
}
