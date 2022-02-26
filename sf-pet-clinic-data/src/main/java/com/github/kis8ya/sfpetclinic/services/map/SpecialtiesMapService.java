package com.github.kis8ya.sfpetclinic.services.map;

import com.github.kis8ya.sfpetclinic.model.Speciality;
import com.github.kis8ya.sfpetclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class SpecialtiesMapService extends AbstractMapService<Speciality> implements SpecialtiesService {
}
