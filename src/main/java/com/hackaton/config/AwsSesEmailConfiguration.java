package com.hackaton.config;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.hackaton.infra.awsses.AwsSesEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSesEmailConfiguration {

    @Bean
    AwsSesEmailService awsSesEmailService(AmazonSimpleEmailService amazonSimpleEmailService) {
        return new AwsSesEmailService(amazonSimpleEmailService);
    }

}
