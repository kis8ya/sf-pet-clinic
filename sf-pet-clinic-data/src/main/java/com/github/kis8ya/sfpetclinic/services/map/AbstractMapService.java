package com.github.kis8ya.sfpetclinic.services.map;

import com.github.kis8ya.sfpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public T save(T object) {
        object.setId(new Random().nextLong(1, Long.MAX_VALUE));
        map.put(object.getId(), object);
        return object;
    }

    public void deleteById(Long id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

}
