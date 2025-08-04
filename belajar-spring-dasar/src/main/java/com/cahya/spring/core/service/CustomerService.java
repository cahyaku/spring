package com.cahya.spring.core.service;

import com.cahya.spring.core.repository.CustomerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
    /**
     * Dependency Injection menggunakan Autowired langsung pada field.
     */
    @Getter
    @Autowired
    @Qualifier("normalCustomerRepository") // untuk memilih bean yang mana yang akan di-inject
    private CustomerRepository normalCustomerRepository;

    @Getter
    @Autowired
    @Qualifier("premiumCustomerRepository") // untuk memilih bean yang mana yang akan di-inject
    private CustomerRepository premiumCustomerRepository;
}
