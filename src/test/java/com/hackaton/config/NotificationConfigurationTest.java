package com.hackaton.config;

import com.hackaton.application.usecases.NotificationUseCases;
import com.hackaton.infra.awsses.AwsSesEmailService;
import com.hackaton.infra.smtp.JavaMailService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class NotificationConfigurationTest {

    @Mock
    private AwsSesEmailService awsSesEmailService;

    @Mock
    private JavaMailService javaMailService;

    @InjectMocks
    private NotificationConfiguration notificationConfiguration;

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
    void notificationUseCases_ReturnsJavaMailService_WhenEmailProviderIsJavaMail() {
        ReflectionTestUtils.setField(notificationConfiguration, "emailProvider", "javaMail");
        NotificationUseCases result = notificationConfiguration.notificationUseCases(awsSesEmailService, javaMailService);
        assertNotNull(result);
        assertInstanceOf(NotificationUseCases.class, result);
    }

    @Test
    void notificationUseCases_ReturnsAwsSesEmailService_WhenEmailProviderIsAws() {
        ReflectionTestUtils.setField(notificationConfiguration, "emailProvider", "aws");
        NotificationUseCases result = notificationConfiguration.notificationUseCases(awsSesEmailService, javaMailService);
        assertNotNull(result);
        assertInstanceOf(NotificationUseCases.class, result);
    }

    @Test
    void notificationUseCases_ThrowsException_WhenEmailProviderIsInvalid() {
        ReflectionTestUtils.setField(notificationConfiguration, "emailProvider", "invalid");
        assertThrows(IllegalArgumentException.class, () -> {
            notificationConfiguration.notificationUseCases(awsSesEmailService, javaMailService);
        });
    }




}