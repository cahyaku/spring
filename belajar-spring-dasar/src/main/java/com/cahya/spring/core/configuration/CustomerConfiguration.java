package com.cahya.spring.core.configuration;

import com.cahya.spring.core.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CustomerConfiguration {

    // Harus dipilih, kalau tidak spring akan bingung dan terjadi error
    @Primary
    @Bean
    public CustomerRepository normalCustomerRepository() {
        return new CustomerRepository();
    }

    @Bean
    public CustomerRepository premiumCustomerRepository() {
        return new CustomerRepository();
    }

    // karena ada dua bean CustomerRepository, kita bisa hapus @Componentnya disana
    // dan kita perlu menambhakan component scan pada class ComponentConfiguration
}
