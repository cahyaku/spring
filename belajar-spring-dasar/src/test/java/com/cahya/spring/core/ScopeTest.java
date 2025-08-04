package com.cahya.spring.core;

import com.cahya.spring.core.data.Bar;
import com.cahya.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {
    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        // Inisialisasi ApplicationContext sebelum setiap test
        applicationContext = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
    }

    /**
     * Ini adalah contoh test untuk scope prototype.
     * Jadi setiap kali kita memanggil getBean(Foo.class), akan membuat objek baru dari Foo.
     * Hasilnya akan mencetak 3 objek Foo yang berbeda.
     */
    @Test
    void testPrototypeScope() {
        Foo foo1 = applicationContext.getBean(Foo.class);
        Foo foo2 = applicationContext.getBean(Foo.class);
        Foo foo3 = applicationContext.getBean(Foo.class);

        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo1, foo3);
        Assertions.assertNotSame(foo2, foo3);
    }

    /**
     * Test DoubletonScope
     * Jadi saat dirunning, akan membuat 2 instance dari Bar.
     */
    @Test
    void testDoubletonScope() {
        // DoubletonScope hanya akan membuat dua instance dari Bar.
        // Jadi bar ke-3 akan mengambil instance pertama lagi.
        // Sedangkan bar ke-4 akan mengambil instance kedua lagi.
        // begitu seterusnya.
        Bar bar1 = applicationContext.getBean(Bar.class);
        Bar bar2 = applicationContext.getBean(Bar.class);
        Bar bar3 = applicationContext.getBean(Bar.class);
        Bar bar4 = applicationContext.getBean(Bar.class);

        // Memastikan bahwa bar1 dan bar3 adalah instance yang sama,
        // begitu juga bar2 dan bar4.
        Assertions.assertSame(bar1, bar3);
        Assertions.assertSame(bar2, bar4);
        
        Assertions.assertNotSame(bar1, bar2);
        Assertions.assertNotSame(bar3, bar4);
    }
}
