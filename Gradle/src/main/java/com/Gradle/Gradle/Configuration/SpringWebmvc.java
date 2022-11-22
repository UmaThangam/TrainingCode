package com.Gradle.Gradle.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebmvc implements WebMvcConfigurer {
    @Autowired
    ValidationInterceptor ValidationInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ValidationInterceptor);//passing the interceptor object.
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**");
    }
}
