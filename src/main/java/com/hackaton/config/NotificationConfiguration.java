package com.hackaton.config;

import com.hackaton.application.usecases.NotificationUseCases;
import com.hackaton.domain.interfaces.EmailInterface;
import com.hackaton.infra.awsses.AwsSesEmailService;
import com.hackaton.infra.smtp.SmtpEmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfiguration {

    @Value("${email.provider}")
    private String emailProvider;

    @Bean
    NotificationUseCases notificationUseCases(AwsSesEmailService awsSesEmailService, SmtpEmailService smtpEmailService) {
        if ("smtp".equalsIgnoreCase(emailProvider)) {
            return new NotificationUseCases(smtpEmailService);
        } else if ("aws".equalsIgnoreCase(emailProvider)) {
            return new NotificationUseCases(awsSesEmailService);
        }
        throw new IllegalArgumentException("Invalid email provider");
    }


}
