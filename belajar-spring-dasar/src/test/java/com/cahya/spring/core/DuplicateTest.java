package com.cahya.spring.core;

import com.cahya.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateTest {
    @Test
    public void testDuplicate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

        // Cara 1
        // Note: Jika kita mencoba mengambil bean Foo tanpa nama,
        // Mengambil bean Foo dari konteks, ini akan menyebabkan konflik
        // karena ada dua bean dengan tipe yang sama (Foo), yakni Foo foo1 dan Foo foo2.
        // Jadi spring binggung, karena tidak pakai nama bean.
//    Foo foo = context.getBean(Foo.class);

        //Cek
        // Akan terjadi exception NoUniqueBeanDefinitionException karena ada lebih dari satu bean dengan tipe Foo
        // Kita bisa menangkap exception ini untuk memastikan bahwa konflik terdeteksi
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo foo = context.getBean(Foo.class);
        });
    }

    // Cara 2
    @Test
    void getBean() {
        // Jika ingin mengambil salah satu bean dengan nama tertentu, kita bisa menggunakan nama bean
        // Misalnya, kita bisa mengambil bean foo1 atau foo2 secara eksplisit
        // Ini akan menghindari konflik karena kita menyebutkan nama bean secara spesifik
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);
        Assertions.assertNotSame(foo1, foo2);
    }
}
