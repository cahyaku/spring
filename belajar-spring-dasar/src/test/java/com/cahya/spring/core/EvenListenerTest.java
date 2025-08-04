package com.cahya.spring.core;

import com.cahya.spring.core.listener.LoginAgainSuccessListener;
import com.cahya.spring.core.listener.LoginSuccessListener;
import com.cahya.spring.core.listener.UserListener;
import com.cahya.spring.core.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EvenListenerTest {

    /**
     * Di sini tinggal panggil listenernya jika ada lebih dari 1 listener yang ingin di panggil.
     */
    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class,
            UserListener.class, // ini listener dengan anotasi @EventListener
    })
    public static class TestConfiguration {
    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setup() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
    }

    @Test
    void testEvent() {
        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("cahya", "cahya"); // ini user dan paswordnya (pasti sukses sesuai di service).
        userService.login("cahya", "salah"); // password salah
        userService.login("ayong", "salah"); // username salah

        //1.  Jadi hasil outputnya akan ada 1 event yang berhasil, yaitu user "cahya" yang login sukses.

        //2. TAPI jika ada lebih dari 1 listener yang di panggil, maka akan ada 2 log yang muncul, ketika di running.

        //3. Seteleh ada listener dari class UserListener.java, yang dibuat dengan anotasi @EventListener,
        // maka akan ada 3 Event listener yang akan di panggil dari UserListener.java. karena ada 3 method yang di buat dengan anotasi @EventListener.
    }
}

