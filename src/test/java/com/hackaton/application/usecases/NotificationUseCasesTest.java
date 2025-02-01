package com.hackaton.application.usecases;

import com.hackaton.domain.enums.NotificationErrorEnum;
import com.hackaton.domain.exceptions.NotificationException;
import com.hackaton.domain.interfaces.EmailInterface;
import com.hackaton.infra.dto.EmailRequestDTO;
import com.hackaton.infra.dto.NotificationRequestDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


class NotificationUseCasesTest {

    @Mock
    private EmailInterface emailInterface;

    @InjectMocks
    private NotificationUseCases notificationUseCases;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void sendNotificationSuccessfully() {
        NotificationRequestDTO request = new NotificationRequestDTO("test@example.com", "Test message");

        notificationUseCases.sendNotification(request);

        verify(emailInterface, times(1)).sendEmail(any(EmailRequestDTO.class));
    }

    @Test
    void sendNotificationFails() {
        NotificationRequestDTO request = new NotificationRequestDTO("test@example.com", "Test message");

        doThrow(new RuntimeException()).when(emailInterface).sendEmail(any(EmailRequestDTO.class));

        NotificationException exception = assertThrows(NotificationException.class, () -> {
            notificationUseCases.sendNotification(request);
        });

        assertEquals(NotificationErrorEnum.ERROR_TO_SEND_EMAIL, exception.getError());
    }


}