package com.cahya.spring.core.listener;


import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class AppStartingListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(@NonNull ApplicationStartedEvent event) {
        log.info("Application starting");
    }

    // QUESTION:
    // Kalau tidak menggunakan bean, bagaimana cara meregistrasikannya?
    // ANSWER:
    // Jadi kita bisa menggunakan SpringApplication
    // Contohnya pada FooApplication.java
    // Jadi di sana tambahkan application.setListeners(List.of(new AppStartingListener()));
}
