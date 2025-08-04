package com.cahya.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Berikut adalah contoh kode untuk membuat unit test pada ApplicationContext menggunakan JUnit 5 dan Spring Framework:
public class ApplicationContextTest {

    // Cara membuat ApplicationContextTest
    @Test
    void testApplicationContext() {
        // masukan nama class konfigurasi yang sesuai -> yakni HelloWorldConfiguration
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // cek apakah context berhasil dibuat
        Assertions.assertNotNull(context, "ApplicationContext should not be null");
    }
}
