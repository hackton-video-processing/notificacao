package com.hackaton.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailConfigurationTest {

    @Autowired
    private JavaMailSenderConfiguration mailConfiguration;

    @Test
    void testJavaMailSenderConfiguration() {
        JavaMailSender mailSender = mailConfiguration.javaMailSender();

        assertNotNull(mailSender);
        assertInstanceOf(JavaMailSenderImpl.class, mailSender);

        JavaMailSenderImpl mailSenderImpl = (JavaMailSenderImpl) mailSender;
        assertEquals("smtp.example.com", mailSenderImpl.getHost());
        assertEquals(587, mailSenderImpl.getPort());
        assertEquals("teste@teste.com", mailSenderImpl.getUsername());
        assertEquals("teste", mailSenderImpl.getPassword());

        assertEquals("smtp", mailSenderImpl.getJavaMailProperties().getProperty("mail.transport.protocol"));
        assertEquals("true", mailSenderImpl.getJavaMailProperties().getProperty("mail.smtp.auth"));
        assertEquals("true", mailSenderImpl.getJavaMailProperties().getProperty("mail.smtp.starttls.enable"));
        assertEquals("true", mailSenderImpl.getJavaMailProperties().getProperty("mail.debug"));
    }



}