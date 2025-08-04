package com.cahya.spring.core.event;

import com.cahya.spring.core.data.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class LoginSuccessEvent extends ApplicationEvent {

    @Getter
    private final User user;

    /**
     * Constructor dengan parameter user yang berhasil login.
     */
    public LoginSuccessEvent(User user) {
        super(user); // set super constructornya menjadi user
        this.user = user;
    }

    // NOTE: Jadi data event ini akan berisi informasi tentang user yang berhasil login.
}

