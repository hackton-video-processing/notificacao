package com.hackaton.infra.javaMail;

import com.hackaton.infra.dto.EmailRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class JavaMailServiceTest {

    private JavaMailSender mailSender;
    private JavaMailService javaMailService;

    @BeforeEach
    void setUp() {
        mailSender = Mockito.mock(JavaMailSender.class);
        javaMailService = new JavaMailService(mailSender);
    }

    @Test
    void sendEmailWithValidRequest() {
        EmailRequestDTO request = new EmailRequestDTO("test@example.com", "Subject", "Message");

        javaMailService.sendEmail(request);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void sendEmailWithEmptySubject() {
        EmailRequestDTO request = new EmailRequestDTO("test@example.com", "", "Message");

        javaMailService.sendEmail(request);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void sendEmailWithEmptyMessage() {
        EmailRequestDTO request = new EmailRequestDTO("test@example.com", "Subject", "");

        javaMailService.sendEmail(request);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void sendEmailWithNullFields() {
        EmailRequestDTO request = new EmailRequestDTO(null, null, null);

        javaMailService.sendEmail(request);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void sendEmailWithSpecialCharacters() {
        EmailRequestDTO request = new EmailRequestDTO("test+alias@example.com", "Subject!@#", "Message!@#");

        javaMailService.sendEmail(request);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}