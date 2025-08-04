package com.cahya.spring.core.data;

import com.cahya.spring.core.aware.IdAware;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Car implements IdAware {

    @Getter
    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    // NEXT: Buat class BeanPostProcessorTest,
    // yang langsung punya static class untuk configuration
}
