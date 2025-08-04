package com.cahya.spring.core;

import com.cahya.spring.core.data.Connection;
import com.cahya.spring.core.data.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {

    // Pakai ConfigurableApplicationContext untuk mendapatkan metode close()
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        // Inisialisasi ApplicationContext sebelum setiap test
        applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);

        // Mendaftarkan shutdown hook untuk menutup context secara otomatis
        applicationContext.registerShutdownHook();
    }

    /**
     * Cara menutup ApplicationContext secara manual
     * Jika tidak ditutup, akan menyebabkan memory leak
     */
    @AfterEach
    void tearDown() {
        // Tutup ApplicationContext setelah setiap test
        // applicationContext.close(); // OPEN ME
    }

    /**
     * Test untuk Connection
     */
    @Test
    void testConnection() {
        Connection connection = applicationContext.getBean(Connection.class);
    }

    /**
     * Test untuk Server
     */
    @Test
    void testServer() {
        applicationContext.getBean("server", Server.class);
    }
}
