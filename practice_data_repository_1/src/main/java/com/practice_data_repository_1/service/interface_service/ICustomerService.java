package com.practice_data_repository_1.service.interface_service;

import com.practice_data_repository_1.model.Customer;
import com.practice_data_repository_1.model.Province;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface ICustomerService extends IGenerateService<Customer>{
    Iterable<Customer> findAllByProvince(Province province);
}
