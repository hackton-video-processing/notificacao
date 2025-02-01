package com.hackaton.domain.enums;

public enum NotificationErrorEnum {

    ERROR_TO_SEND_EMAIL(400, "Unable to send email");

    private final Integer httpStatusCode;
    private final String detail;

    NotificationErrorEnum(Integer httpStatusCode, String detail) {
        this.httpStatusCode = httpStatusCode;
        this.detail = detail;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getDetail() {
        return detail;
    }
}
