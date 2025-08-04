package com.cahya.spring.core.service;

import com.cahya.spring.core.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Contoh component pada Spring.
 *
 * @Component akan diregistrasikan sebagai bean baru.
 * <p>
 * Jika ingin menjadikan prototype, gunakan @Scope("prototype").
 * sebelum anotasi @Component atau setelahnya.
 */
@Component
public class ProductService {
    @Getter
    private final ProductRepository productRepository;

    /**
     * Constructor untuk ProductRepository.
     * <p>
     * Jadi spring akan membaca contructor ini butuh parameter apa,
     * lalu akan mencari bean yang sesuai dengan parameter tersebut.
     * Kemudian akan meng-inject bean tersebut ke dalam parameter.
     *
     * @param productRepository instance dari ProductRepository
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Jika ada constructor lainnya, maka harus ditandai dengan @Autowired
     * Contounya kita ingin memnggunakan constructor di atas, jadi tambahkan @Autowired
     */
    public ProductService(ProductRepository productRepository, String name) {
        this.productRepository = productRepository;
    }
}

