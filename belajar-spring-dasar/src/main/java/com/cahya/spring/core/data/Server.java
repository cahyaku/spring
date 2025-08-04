package com.cahya.spring.core.data;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {

    /**
     * Jika kelas ini implementasi dari InitializingBean dan DisposableBean,
     * maka perlu memanggil destroy() dan afterPropertiesSet()
     */

    /**
     * Sehingga akan ada perubahan pada class LifecycleConfiguration.java
     */
    @PostConstruct
    public void start() {
        log.info("Server started");
    }

    @PreDestroy
    public void stop() {
        log.info("Server stopped");
    }
}
