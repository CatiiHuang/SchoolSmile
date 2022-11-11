package com.faceschool.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:E://schoolface/homework/");
        registry.addResourceHandler("/image/**").addResourceLocations("file:E://schoolface/images/");
        registry.addResourceHandler("/IMGS/**").addResourceLocations("file:E://schoolface/images/IMGS/");
        super.addResourceHandlers(registry);
    }
}
