package com.cahya.spring.core;

import com.cahya.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {
    @Test
    void testCreateBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Assertions.assertNotNull(context);
    }

    /**
     * Coba running.
     * Dengan menggunakan @Bean, maka akan membuat bean Foo hanya 1 kali.
     * Karena bean Foo ini adalah singleton,
     * maka ketika kita memanggil getBean(Foo.class) akan mendapatkan instance yang sama.
     */
    @Test
    void testGetBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        // Jadi jika memanggil getBean berkali-kali, dengan tipe yang sama (object yang sama),
        // sebenarnya ia mengembalikan object yang sama (itu-itu saja).
    }
}
