package com.hackaton.config;

import com.hackaton.infra.awsses.AwsSesEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.ses.SesClient;

@Configuration
public class AwsSesEmailConfiguration {

    @Bean
    AwsSesEmailService awsSesEmailService(SesClient sesClient) {
        return new AwsSesEmailService(sesClient);
    }

}
