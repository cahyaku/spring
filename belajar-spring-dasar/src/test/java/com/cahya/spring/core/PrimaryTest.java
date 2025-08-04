package com.cahya.spring.core;

import com.cahya.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        // Inisialisasi ApplicationContext dengan PrimaryConfiguration
        applicationContext = new AnnotationConfigApplicationContext(PrimaryConfiguration.class);
    }

    @Test
    public void testGetPrimary() {
        // cara 1
        // Dapatkan bean Foo yang ditandai dengan @Primary
        // dengan menggunakan getBean(Foo.class)
        Foo foo = applicationContext.getBean(Foo.class);

        // cara 2
        // jika ingin mendapatkan bean dengan nama tertentu, kita bisa menggunakan nama bean
        Foo foo1 = applicationContext.getBean("foo1", Foo.class);
        // Hasil kedua ini akan sama dengan hasil pertama, karena foo1 adalah bean yang ditandai dengan @Primary

        // Memanggil foo2
        Foo foo2 = applicationContext.getBean("foo2", Foo.class);

        // Memastikan bahwa foo1 adalah bean yang ditandai dengan @Primary.
        // Jadi foo1 harus sama dengan foo
        Assertions.assertSame(foo, foo1);

        // Memastikan bahwa foo2 tidak sama dengan foo1
        Assertions.assertNotSame(foo1, foo2);
        // Memastikan bahwa foo2 tidak sama dengan foo
        Assertions.assertNotSame(foo, foo2);
    }
}
