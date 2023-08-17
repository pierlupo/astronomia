package com.application;

import com.application.config.InfrastructureConfig;
import com.application.config.PresentationConfig;
import com.application.config.PresentationInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication infra = new SpringApplication(InfrastructureConfig.class);
        infra.setDefaultProperties(Collections.singletonMap("server.port", "8088"));
        ConfigurableApplicationContext infraContext = infra.run();

        SpringApplication apiRest = new SpringApplication(PresentationConfig.class);
        apiRest.setDefaultProperties(Collections.singletonMap("server.port", "8087"));
        apiRest.addInitializers(new PresentationInitializer(infraContext));
        ConfigurableApplicationContext apiRestContext = apiRest.run();
    }

}
