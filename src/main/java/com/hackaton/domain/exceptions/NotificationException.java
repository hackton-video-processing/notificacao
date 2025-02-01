package com.hackaton.domain.exceptions;

import com.hackaton.domain.enums.NotificationErrorEnum;

public class NotificationException  extends RuntimeException{

    private final NotificationErrorEnum error;

    public NotificationException(NotificationErrorEnum error) {
        this.error = error;
    }

    public NotificationErrorEnum getError() {
        return this.error;
    }
}
