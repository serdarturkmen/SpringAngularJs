package com.example.thymeleaf.config;

import com.example.thymeleaf.app.logging.LoggingAspect;
import org.springframework.context.annotation.*;

//@Configuration
//@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
