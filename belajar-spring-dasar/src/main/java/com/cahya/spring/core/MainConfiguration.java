package com.cahya.spring.core;

import com.cahya.spring.core.configuration.BarConfiguration;
import com.cahya.spring.core.configuration.FooConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Contoh Import pada Spring Configuration.
 * Ini jika import lebih dari satu konfigurasi.
 */
@Configuration
@Import({
        FooConfiguration.class,
        BarConfiguration.class
})
public class MainConfiguration {
    /**
     * Kemudian ke class ImportTest.java
     */
}
