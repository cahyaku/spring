package com.cahya.spring.core;

import com.cahya.spring.core.client.PaymentGatewayClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setup() {
        applicationContext = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testFactory() {
        PaymentGatewayClient gatewayClient = applicationContext.getBean(PaymentGatewayClient.class);
        Assertions.assertNotNull(gatewayClient);

        // Cek apakah bean yang dihasilkan sesuai dengan yang diharapkan
        Assertions.assertEquals("https://example.com", gatewayClient.getEndpoint());
        Assertions.assertEquals("private", gatewayClient.getPrivateKey());
        Assertions.assertEquals("public", gatewayClient.getPublicKey());
    }
}
