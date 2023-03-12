package ru.partezan7.proto.prototype.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        // Available without authentication
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/public").setViewName("public");
        registry.addViewController("/registration").setViewName("registration");
        // Authentication
        registry.addViewController("/login").setViewName("login");
        // Available only with authentication
        registry.addViewController("/private").setViewName("private");
        registry.addViewController("/main").setViewName("main-page");
        registry.addViewController("/filter").setViewName("main-page");
    }

}
