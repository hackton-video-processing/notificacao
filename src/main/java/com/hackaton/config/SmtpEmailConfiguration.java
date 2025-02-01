package com.hackaton.config;

import com.hackaton.infra.smtp.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class SmtpEmailConfiguration {

    @Bean
    SmtpEmailService smtpEmailService(JavaMailSender javaMailSender) {
        return new SmtpEmailService(javaMailSender);
    }

}
