package com.cahya.spring.core;

import com.cahya.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DuplicateConfiguration {

    // Membuat dua bean dengan tipe yang sama (Foo)
    // Ini akan menyebabkan konflik jika tidak ditangani dengan benar
    // Nama bean harus unik dalam konteks Spring
    @Bean
    public Foo foo1() {
        return new Foo();
    }

    @Bean
    public Foo foo2() {
        return new Foo();
    }
}
