package com.github.kis8ya.sfpetclinic.services.jpa;

import com.github.kis8ya.sfpetclinic.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractJpaService<T extends BaseEntity, R extends CrudRepository<T, Long>> {

    protected R repository;

    public AbstractJpaService(R repository) {
        this.repository = repository;
    }

    public Set<T> findAll() {
        Set<T> result = new HashSet<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public T save(T object) {
        return repository.save(object);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void delete(T object) {
        repository.delete(object);
    }

}
