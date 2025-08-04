package com.cahya.spring.core.client;

import lombok.Data;

/**
 * Anggap class ini adalah class yang di buat Payment Gateway
 * Jadi kita punya akses untuk mengubahnya
 * <p>
 * Anggap ini class party library
 * sehingga tidak bisa menambahkan anotasi @Component, @Service, @Repository, @Controller, dll
 */
@Data
public class PaymentGatewayClient {
    private String endpoint;
    private String privateKey;
    private String publicKey;

    // QUESTION: Bagiamana cara memebuat bean PaymentGatewayClient tanpa menggunakan anotation @Bean?
    // ANSWER: Kita bisa membuatnya dengan cara membuat class yang mengimplementasikan interface FactoryBean,
    // jadi buat sebuah class PaymentGatewayClientFactory yang mengimplementasikan FactoryBean<PaymentGatewayClient>
    // ini ada di package factory

}