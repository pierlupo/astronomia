package com.application.config;

import com.domaine.service.AppUserServiceImpl;
import com.domaine.service.CelestialObjectImpl;
import com.domaine.service.CommentServiceImpl;
import com.infrastructure.repository.impl.AppUserRepositoryImpl;
import com.infrastructure.repository.impl.CelestialObjectRepositoryImpl;
import com.infrastructure.repository.impl.CommentRepositoryImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class PresentationInitializer implements ApplicationContextInitializer {

    private final ConfigurableApplicationContext infraContext;

    public PresentationInitializer(ConfigurableApplicationContext infraContext) {
        this.infraContext = infraContext;
    }
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableListableBeanFactory registry = applicationContext.getBeanFactory();
        registry.registerSingleton("CelestialObjectService", new CelestialObjectImpl(infraContext.getBean(CelestialObjectRepositoryImpl.class)));
        registry.registerSingleton("AppUserService", new AppUserServiceImpl(infraContext.getBean(AppUserRepositoryImpl.class)));
        registry.registerSingleton("CommentService", new CommentServiceImpl(infraContext.getBean(CommentRepositoryImpl.class)));

    }
}
