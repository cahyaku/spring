package com.cahya.spring.core;

import com.cahya.spring.core.data.Connection;
import com.cahya.spring.core.data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfiguration {

    @Bean
    public Connection connection() {
        return new Connection();
    }

    /**
     * Pada @Bean dapat meregistrasikan init() dan destroy() method.
     * Kemudian test pada LifeCycleTest.java
     * <p>
     * Ini tinggal @Bean saja (tdk perlu initMethod), karena Server sudah menggunakan
     * menggunakan @postConstruct dan @PreDestroy.
     */
//    @Bean(initMethod = "start", destroyMethod = "stop")
    @Bean
    public Server server() {
        return new Server();
    }
}
