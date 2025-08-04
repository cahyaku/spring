package com.cahya.spring.core.listener;

import com.cahya.spring.core.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Component untuk langsung membuat bean
 */
@Slf4j
@Component
public class UserListener {

    /**
     * Dengan menggunakan anotasi @EventListener, kita bisa langsung membuat listener
     * tanpa perlu membuat class yang mengimplementasikan ApplicationListener.
     * <p>
     * Kita dapat membuat beberapa listener dengan anotasi @EventListener, seperti di bawah ini.
     * <p>
     * Selaian itu tipe pada @EventListener(tipe di sini) bisa berbeda-beda, sesuai dengan event yang ingin didengarkan.
     *
     * @EventListener akan mendengarkan event yang sesuai dengan tipe yang diberikan.
     * Dalam hal ini, kita mendengarkan LoginSuccessEvent.
     */

    // Ini adalah bean yang akan didaftarkan sebagai listener
    @EventListener(classes = LoginSuccessEvent.class) // tambahkan class untuk menghindari ambigu
    public void onLoginSuccessEvent(LoginSuccessEvent event) {
        log.info("Success login for user with annotation {}", event.getUser());
    }

    @EventListener(classes = LoginSuccessEvent.class) // tambahkan class untuk menghindari ambigu
    public void onLoginSuccessEvent2(LoginSuccessEvent event) {
        log.info("Success login for user with annotation {}", event.getUser());
    }

    @EventListener(classes = LoginSuccessEvent.class) // tambahkan class untuk menghindari ambigu
    public void onLoginSuccessEvent3(LoginSuccessEvent event) {
        log.info("Success login for user with annotation {}", event.getUser());
    }
}
