package com.cahya.spring.core;

import com.cahya.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanNameConfiguration {
    //    @Primary
    // Menggunakan name untuk memberikan nama khusus pada bean
    @Bean(name = "fooFirst")
    public Foo foo1() {
        return new Foo();
    }

    // Menggunakan name untuk memberikan nama khusus pada bean
    @Bean(name = "fooSecond")
    public Foo foo2() {
        return new Foo();
    }
}
