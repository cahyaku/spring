package com.cahya.spring.core;

import com.cahya.spring.core.cyclic.CyclicA;
import com.cahya.spring.core.cyclic.CyclicB;
import com.cahya.spring.core.cyclic.CyclicC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CyclicConfiguration {
    @Bean
    public CyclicA getCyclicA(CyclicB cyclicB) {
        return new CyclicA(cyclicB);
    }

    @Bean
    public CyclicB getCyclicB(CyclicC cyclicC) {
        return new CyclicB(cyclicC);
    }

    @Bean
    public CyclicC getCyclicC(CyclicA cyclicA) {
        return new CyclicC(cyclicA);
    }
}
