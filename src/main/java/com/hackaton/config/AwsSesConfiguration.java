package com.hackaton.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;


@Configuration
public class AwsSesConfiguration {

    @Bean
    public SesClient sesClient() {
        return SesClient.builder()
                .credentialsProvider(ProfileCredentialsProvider.create("default"))
                .region(Region.US_EAST_1)
                .build();
    }
}
