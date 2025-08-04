package com.cahya.spring.core;

import com.cahya.spring.core.data.Bar;
import com.cahya.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class DependsOnConfiguration {
    /**
     * Pada kasus ini, kedua bean Foo dan Bar tidak memiliki ketergantungan satu sama lain.
     * Sehingga spring secara otomatis random memilih mana yang akan dibuat terlebih dahulu.
     * <p>
     * Tapi dengan dependsOn, kita bisa menentukan mana yang harus dibuat terlebih dahulu.
     * coba runing di test DependsOnTest.java, untuk melihat hasilnya.
     * <p>
     * DepensOn bisa ditambahkan jika lebih dari satu bean yang harus dibuat terlebih dahulu.
     * <p>
     * TAPI karena ada @Lazy pada Foo, maka Foo tidak akan dibuat.
     * Coba saja komen Lazy untuk melihat hasil lainnya.
     * Sehingga setelah ditambahkan @Lazy, hasilnya hanya ada Creating Bar bean.
     */

    @Lazy
    @Bean
    @DependsOn("bar") // Bar akan dibuat terlebih dahulu sebelum Foo
    public Foo foo() {
        log.info("Creating new foo");
        return new Foo();
    }

    @Bean
    public Bar bar() {
        log.info("Creating new bar");
        return new Bar();
    }
}
