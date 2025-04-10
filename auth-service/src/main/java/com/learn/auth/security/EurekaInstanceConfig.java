package com.learn.auth.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EurekaInstanceConfig implements ApplicationListener<ApplicationReadyEvent> {

    private final Environment env;

    @Value("${spring.application.name}")
    private String appName;

    public EurekaInstanceConfig(Environment env) {
        this.env = env;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        String port = env.getProperty("local.server.port");
        if (port != null) {
            System.setProperty("eureka.instance.nonSecurePort", port);
            System.setProperty("eureka.instance.instanceId", appName + ":" + port);
            System.out.println("✅ Registered with Eureka on port: " + port);
        } else {
            System.err.println("❌ Could not set Eureka port — 'local.server.port' is null");
        }
    }
}
