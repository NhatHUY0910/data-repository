package com.practice_data_repository_1.repository;

import com.practice_data_repository_1.model.Customer;
import com.practice_data_repository_1.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
    Iterable<Customer> findAllByProvince(Province province);
}
