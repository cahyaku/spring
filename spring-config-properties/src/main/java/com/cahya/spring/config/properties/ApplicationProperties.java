package com.cahya.spring.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Contoh menggunakan @ConfigurationProperties
 * dengan prefix "spring.application"
 * karena di application.properties diawali dengan "spring.application"
 * jika application saja, maka prefix-nya tinggal ditulis "application".
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.application")
public class ApplicationProperties {

    private String name;

    private Integer version;

    private boolean productionMode;
}
