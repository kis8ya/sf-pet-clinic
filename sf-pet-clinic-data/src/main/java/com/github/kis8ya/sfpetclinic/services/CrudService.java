package com.github.kis8ya.sfpetclinic.services;

import java.util.Optional;
import java.util.Set;

public interface CrudService<T, ID> {

    Optional<T> findById(ID id);
    Set<T> findAll();
    T save(T obj);
    void delete(T obj);
    void deleteById(ID id);

}
