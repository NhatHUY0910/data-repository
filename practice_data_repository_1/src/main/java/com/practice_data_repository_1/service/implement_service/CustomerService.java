package com.practice_data_repository_1.service.implement_service;

import com.practice_data_repository_1.model.Customer;
import com.practice_data_repository_1.model.Province;
import com.practice_data_repository_1.repository.ICustomerRepository;
import com.practice_data_repository_1.service.interface_service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
