package com.gouzal.icrm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/images/**",
                "/font/**",
                "/css/**",
                "/js/**",
                "/webjars/**")
                .addResourceLocations(
                        "classpath:/static/images/",
                        "classpath:/static/font/",
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "/webjars/");
    }
}