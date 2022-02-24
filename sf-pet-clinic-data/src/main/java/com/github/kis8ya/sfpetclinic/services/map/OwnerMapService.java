package com.github.kis8ya.sfpetclinic.services.map;

import com.github.kis8ya.sfpetclinic.model.Owner;
import com.github.kis8ya.sfpetclinic.model.Pet;
import com.github.kis8ya.sfpetclinic.services.OwnerService;
import com.github.kis8ya.sfpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {

    private final PetService petService;

    public OwnerMapService(PetService petService) {
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
        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        for (Owner owner : map.values()) {
            if (owner.getLastName().equals(lastName)) {
                return owner;
            }
        }
        return null;
    }

}
