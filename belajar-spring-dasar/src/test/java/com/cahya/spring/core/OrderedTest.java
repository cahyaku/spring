package com.cahya.spring.core;

import com.cahya.spring.core.data.Car;
import com.cahya.spring.core.processor.IdGeneratorBeanPostProcessor;
import com.cahya.spring.core.processor.PrefixIdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class OrderedTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class,
            PrefixIdGeneratorBeanPostProcessor.class
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void name() {
        Car car = applicationContext.getBean(Car.class);
        // Pastikan ID tidak null
        Assertions.assertNotNull(car.getId());
        // Pastikan ID yang dihasilkan diawali dengan "Prefix"
        Assertions.assertTrue(car.getId().startsWith("Prefix"));
        System.out.println("Car ID: " + car.getId());

        // lihat resultnya di terminal, IdGeneratorBeanPostProcessor akan dieksekusi terlebih dahulu
        // kemudian PrefixIdGeneratorBeanPostProcessor
    }
}
