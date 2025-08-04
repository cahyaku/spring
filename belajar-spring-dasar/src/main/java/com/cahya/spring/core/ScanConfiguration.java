package com.cahya.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Contoh scan configuration pada Spring.
 * Sehingga semua configurasi yang ada pada package
 * akan di-scan oleh Spring.
 * <p>
 * Ini lebih baik daripada menggunakan import satu per satu seperti pada class MainConfiguration.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.cahya.spring.core.configuration"
})
public class ScanConfiguration {
}
