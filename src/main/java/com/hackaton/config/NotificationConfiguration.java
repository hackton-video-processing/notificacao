package com.hackaton.config;

import com.hackaton.application.usecases.NotificationUseCases;
import com.hackaton.infra.awsses.AwsSesEmailService;
import com.hackaton.infra.javaMail.JavaMailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfiguration {

    @Value("${email.provider}")
    private String emailProvider;

    @Bean
    NotificationUseCases notificationUseCases(AwsSesEmailService awsSesEmailService, JavaMailService javaMailService) {
        if ("javaMail".equalsIgnoreCase(emailProvider)) {
            return new NotificationUseCases(javaMailService);
        } else if ("aws".equalsIgnoreCase(emailProvider)) {
            return new NotificationUseCases(awsSesEmailService);
        }
        throw new IllegalArgumentException("Invalid email provider");
    }


}
