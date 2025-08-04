package com.cahya.spring.core;

import com.cahya.spring.core.data.Bar;
import com.cahya.spring.core.data.Foo;
import com.cahya.spring.core.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }

    /**
     * Dependency Injection
     * Ini contoh yang dilakukan oleh Spring secara otomatis
     * Jadi kita tidak perlu melakukan manual
     * <p>
     * Jadi cukup set paramter pada FooBar bean.
     */
    @Test
    void testDI() {
        Foo foo = applicationContext.getBean("fooSecond", Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }

    /**
     * Dependency Injection
     * Ini contoh yang dilakukan secara manual
     * bayangkan jika ada banyak class yang harus di-inject
     */
    @Test
    public void testNoDI() {
        var foo = new Foo();
        var bar = new Bar();

        // Melakukan injeksi
        // Memasukan data Foo dan Bar ke dalam FooBar
        var fooBar = new FooBar(foo, bar);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}
