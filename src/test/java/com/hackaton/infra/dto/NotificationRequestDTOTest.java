package com.hackaton.infra.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationRequestDTOTest {

    @Test
    void notificationRequestDTOCreationWithValidData() {
        NotificationRequestDTO requestDTO = new NotificationRequestDTO("user@example.com", "Test message");

        assertNotNull(requestDTO);
        assertEquals("user@example.com", requestDTO.userEmail());
        assertEquals("Test message", requestDTO.message());
    }

    @Test
    void notificationRequestDTOCreationWithEmptyEmail() {
        NotificationRequestDTO requestDTO = new NotificationRequestDTO("", "Test message");

        assertNotNull(requestDTO);
        assertEquals("", requestDTO.userEmail());
        assertEquals("Test message", requestDTO.message());
    }

    @Test
    void notificationRequestDTOCreationWithEmptyMessage() {
        NotificationRequestDTO requestDTO = new NotificationRequestDTO("user@example.com", "");

        assertNotNull(requestDTO);
        assertEquals("user@example.com", requestDTO.userEmail());
        assertEquals("", requestDTO.message());
    }

    @Test
    void notificationRequestDTOCreationWithNullEmail() {
        NotificationRequestDTO requestDTO = new NotificationRequestDTO(null, "Test message");

        assertNotNull(requestDTO);
        assertNull(requestDTO.userEmail());
        assertEquals("Test message", requestDTO.message());
    }

    @Test
    void notificationRequestDTOCreationWithNullMessage() {
        NotificationRequestDTO requestDTO = new NotificationRequestDTO("user@example.com", null);

        assertNotNull(requestDTO);
        assertEquals("user@example.com", requestDTO.userEmail());
        assertNull(requestDTO.message());
    }

}