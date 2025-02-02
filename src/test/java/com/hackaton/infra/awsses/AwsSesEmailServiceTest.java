package com.hackaton.infra.awsses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.AmazonSimpleEmailServiceException;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.hackaton.infra.dto.EmailRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AwsSesEmailServiceTest {

    @Mock
    private AmazonSimpleEmailService amazonSimpleEmailService;

    @InjectMocks
    private AwsSesEmailService awsSesEmailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendEmail_SendsEmailWithCorrectParameters() {
        EmailRequestDTO request = new EmailRequestDTO("test@example.com", "Test Subject", "Test Message");

        awsSesEmailService.sendEmail(request);

        ArgumentCaptor<SendEmailRequest> captor = ArgumentCaptor.forClass(SendEmailRequest.class);
        verify(amazonSimpleEmailService).sendEmail(captor.capture());
        SendEmailRequest capturedRequest = captor.getValue();

        assertEquals("test@example.com", capturedRequest.getDestination().getToAddresses().get(0));
        assertEquals("Test Subject", capturedRequest.getMessage().getSubject().getData());
        assertEquals("Test Message", capturedRequest.getMessage().getBody().getText().getData());
    }

    @Test
    void sendEmail_ThrowsException_WhenEmailRequestIsNull() {
        EmailRequestDTO request = new EmailRequestDTO("test@example.com", "Test Subject", "Test Message");

        when(amazonSimpleEmailService.sendEmail(any(SendEmailRequest.class))).thenThrow(AmazonSimpleEmailServiceException.class);

        assertThrows(AmazonSimpleEmailServiceException.class, () -> {
            awsSesEmailService.sendEmail(request);
        });
    }


}