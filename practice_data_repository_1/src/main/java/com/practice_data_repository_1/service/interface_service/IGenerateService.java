package com.practice_data_repository_1.service.interface_service;

import java.util.Optional;

public interface IGenerateService<T>{
    Iterable<T> findAll();
    void save(T t);
    Optional<T> findById(int id);
    void delete(int t);
}
