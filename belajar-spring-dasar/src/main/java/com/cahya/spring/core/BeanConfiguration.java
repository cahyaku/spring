package com.cahya.spring.core;

import com.cahya.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * BeanConfiguration is a Spring configuration class that can be used to define beans
 * and other configurations related to the application.
 * Currently, it does not contain any bean definitions or configurations.
 * Bean configuration adalah kelas konfigurasi Spring yang dapat digunakan untuk mendefinisikan bean.
 */
@Slf4j
@Configuration
public class BeanConfiguration {

    /**
     * Method ini mendefinisikan bean dengan nama "foo" yang akan dikelola oleh Spring.
     * Bean ini adalah instance dari kelas Foo.
     * Jadi wajib menggunakan anotasi @Bean untuk mendefinisikan bean.
     *
     * @return instance dari Foo
     */
    @Bean
    public Foo foo() {
        Foo foo = new Foo();// Membuat instance dari Foo (objek Foo).
        log.info("Create new foo"); // Log untuk memastikan apakah dia dipanggil atau tidak
        return foo;
    }
}
