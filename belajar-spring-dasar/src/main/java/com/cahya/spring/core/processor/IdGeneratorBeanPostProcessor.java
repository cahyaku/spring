package com.cahya.spring.core.processor;

import com.cahya.spring.core.aware.IdAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class IdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {
    // Kita bebas implement method postProcessBeforeInitialization
    // atau postProcessAfterInitialization.

    // PostProcessBeforeInitialization jika tidak peduli dengan dependecynya
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanCreationException {
        log.info("Id Generator Processor for bean {}", beanName);
        if (bean instanceof IdAware idAware) {
            log.info("Set Id Generator for bean {}", beanName);
            idAware.setId(UUID.randomUUID().toString());
        }
        return bean;
    }

    /**
     * Ini implemen getOrder untuk menentukan urutan eksekusi
     */
    @Override
    public int getOrder() {
        return 1;
        // Semakin kecil angkanya, semakin awal dieksekusi
        // Misalnya -1, 0, 1, 2, dst.
    }

    // NEXT: membuat sebuah bean yang mengimplement IdAware
    // Contohnya class Car yang implement IdAware, pada package data.
}
