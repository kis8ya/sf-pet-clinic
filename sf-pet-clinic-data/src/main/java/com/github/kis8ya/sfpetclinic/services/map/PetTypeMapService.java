package com.github.kis8ya.sfpetclinic.services.map;

import com.github.kis8ya.sfpetclinic.model.PetType;
import com.github.kis8ya.sfpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService {
}
