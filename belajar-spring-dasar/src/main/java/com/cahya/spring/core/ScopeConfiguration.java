package com.cahya.spring.core;

import com.cahya.spring.core.data.Bar;
import com.cahya.spring.core.data.Foo;
import com.cahya.spring.core.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopeConfiguration {
    /**
     * Scope prototype adalah scope yang membuat bean baru setiap kali bean tersebut diminta.
     * Ini berbeda dengan scope singleton yang hanya membuat satu instance dari bean tersebut.
     */
    @Bean
    @Scope("prototype")
    public Foo foo() {
        log.info("Creating new foo");// Log untuk melihat kapan bean Foo dibuat
        return new Foo();
    }

    /**
     * Contoh membuat scope kustom.
     * CustomScopeConfigurer digunakan untuk mendefinisikan scope kustom.
     *
     * @return
     */
    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        // Masukkan scope kustom ke dalam CustomScopeConfigurer, dengan method addScope().
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    /**
     * Contoh penggunaan scope kustom.
     * Scope doubleton adalah scope yang hanya membuat dua instance dari bean tersebut.
     *
     * @return
     */
    @Bean
    @Scope("doubleton")
    public Bar bar() {
        log.info("Creating new bar");
        return new Bar();
    }
}
