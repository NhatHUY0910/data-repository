package com.practice_data_repository_1.service.implement_service;

import com.practice_data_repository_1.model.Province;
import com.practice_data_repository_1.repository.IProvinceRepository;
import com.practice_data_repository_1.service.interface_service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public Optional<Province> findById(int id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        provinceRepository.deleteById(id);
    }
}
