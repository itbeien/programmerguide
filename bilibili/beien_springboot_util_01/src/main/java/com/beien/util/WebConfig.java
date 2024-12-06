package com.beien.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author beien
 * @date 2023-05-19 19:33
 * Copyright© 2023 beien
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public AccessLimitInterceptor getSessionInterceptor() {
        return new AccessLimitInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/accessLimit/*");
    }
}
