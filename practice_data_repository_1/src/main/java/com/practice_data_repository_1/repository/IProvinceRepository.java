package com.practice_data_repository_1.repository;

import com.practice_data_repository_1.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface IProvinceRepository extends CrudRepository<Province, Integer> {
}
