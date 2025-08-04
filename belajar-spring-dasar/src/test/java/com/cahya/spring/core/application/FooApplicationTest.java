package com.cahya.spring.core.application;

import com.cahya.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Memakai @SpringBootTest untuk testing
 */
@SpringBootTest(classes = FooApplication.class)
public class FooApplicationTest {
    // Tidak perlu buat application context lagi, karena sudah dibuat secara otomatis oleh @SpringBootTest

    @Autowired
    Foo foo;

    @Test
    void testSpringBoot() {
        Assertions.assertNotNull(foo);
    }
    // ketika di running masih ada error, ini karena JDK 21 belum support
}
