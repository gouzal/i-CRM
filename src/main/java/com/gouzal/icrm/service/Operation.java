package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

public interface Operation<T> {
    public List<T> findAll();

    public Optional<T> findById(Long id);

    public void save(T instance);

    public void deleteById(Long id);
}
