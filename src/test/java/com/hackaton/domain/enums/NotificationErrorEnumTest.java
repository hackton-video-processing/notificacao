package com.hackaton.domain.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationErrorEnumTest {

    @Test
    void getHttpStatusCode_ReturnsCorrectHttpStatusCode() {
        NotificationErrorEnum error = NotificationErrorEnum.ERROR_TO_SEND_EMAIL;
        assertEquals(400, error.getHttpStatusCode());
    }

    @Test
    void getDetail_ReturnsCorrectDetailMessage() {
        NotificationErrorEnum error = NotificationErrorEnum.ERROR_TO_SEND_EMAIL;
        assertEquals("Unable to send email", error.getDetail());
    }
}