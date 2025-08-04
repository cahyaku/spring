package com.cahya.spring.core.factory;

import com.cahya.spring.core.client.PaymentGatewayClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Apapun yang bisa dilakukan di component bisa dilakukan di FactoryBean ini.
 * Bedanya adalah:
 * di @Component biasanya objectnya adalah si class itu sendiri,
 * sedangkan di FactoryBean ini objectnya adalah object yang dihasilkan oleh method getObject()
 */
@Component("paymentGatewayClient")
public class PaymentGatewayClientFactoryBean implements FactoryBean<PaymentGatewayClient> {
    @Override
    public PaymentGatewayClient getObject() throws Exception {
        PaymentGatewayClient client = new PaymentGatewayClient();
        client.setEndpoint("https://example.com");
        client.setPrivateKey("private");
        client.setPublicKey("public");
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}
