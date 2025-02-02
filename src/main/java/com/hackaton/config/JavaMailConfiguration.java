package com.hackaton.config;

import com.hackaton.infra.smtp.JavaMailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class JavaMailConfiguration {

    @Bean
    JavaMailService javaMailService(JavaMailSender javaMailSender) {
        return new JavaMailService(javaMailSender);
    }

}
