package com.hackaton.domain.exceptions;

import com.hackaton.domain.enums.NotificationErrorEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationExceptionTest {

    @Test
    void getError_ReturnsCorrectError() {
        NotificationErrorEnum errorEnum = NotificationErrorEnum.ERROR_TO_SEND_EMAIL;
        NotificationException exception = new NotificationException(errorEnum);
        assertEquals(errorEnum, exception.getError());
    }

    @Test
    void constructor_SetsErrorCorrectly() {
        NotificationErrorEnum errorEnum = NotificationErrorEnum.ERROR_TO_SEND_EMAIL;
        NotificationException exception = new NotificationException(errorEnum);
        assertNotNull(exception.getError());
        assertEquals(errorEnum, exception.getError());
    }
}