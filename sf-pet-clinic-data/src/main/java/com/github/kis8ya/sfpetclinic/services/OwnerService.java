package com.github.kis8ya.sfpetclinic.services;

import com.github.kis8ya.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
