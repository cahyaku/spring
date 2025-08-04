package com.cahya.spring.core;

import com.cahya.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryConfiguration {
    /**
     * Ini adalah contoh penggunaan anotasi @Primary untuk menentukan bean mana yang akan digunakan.
     * Jika ada beberapa bean dengan tipe yang sama,
     * bean yang ditandai dengan @Primary
     * akan menjadi pilihan default
     *
     * @return Foo
     */
    @Primary
    @Bean
    public Foo foo1() {
        return new Foo();
    }

    @Bean
    public Foo foo2() {
        return new Foo();
    }

}

