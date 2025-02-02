package com.hackaton.config;

import com.hackaton.infra.smtp.JavaMailService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;

class JavaMailConfigurationTest {


    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private JavaMailConfiguration javaMailConfiguration;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void javaMailService_ReturnsJavaMailServiceInstance_WhenJavaMailSenderIsProvided() {
        JavaMailService result = javaMailConfiguration.javaMailService(javaMailSender);
        assertNotNull(result);
        assertInstanceOf(JavaMailService.class, result);
    }

}