package com.cahya.spring.core;

import com.cahya.spring.core.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "com.cahya.spring.core.repository",
        "com.cahya.spring.core.service",
        "com.cahya.spring.core.configuration"
})
@Import(MultiFoo.class)
public class ComponenConfiguration {
    // disini sama bisa pakai annotation lainnya
//    seperti @Bean, @Import, @PropertySource, dll.
}
