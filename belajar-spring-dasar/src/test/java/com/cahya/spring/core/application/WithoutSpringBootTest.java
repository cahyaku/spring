package com.cahya.spring.core.application;

import com.cahya.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WithoutSpringBootTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(FooApplication.class);
        applicationContext.registerShutdownHook();
    }

    /**
     * Test kosongkan saja karena pasti error karena bar tidak ada
     */
    @Test
    void testFoo() {
        Foo foo = applicationContext.getBean(Foo.class);
    }
}
