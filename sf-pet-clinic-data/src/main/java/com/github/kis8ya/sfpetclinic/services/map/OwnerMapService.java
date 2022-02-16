package com.github.kis8ya.sfpetclinic.services.map;

import com.github.kis8ya.sfpetclinic.model.Owner;
import com.github.kis8ya.sfpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {

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
