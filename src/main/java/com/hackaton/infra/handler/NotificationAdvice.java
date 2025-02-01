package com.hackaton.infra.handler;

import com.hackaton.domain.exceptions.NotificationException;
import com.hackaton.infra.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotificationAdvice {

    @ExceptionHandler(value = {NotificationException.class})
    ResponseEntity<Object> notificationExceptionHandler(NotificationException exception) {
        return ResponseEntity.status(HttpStatus.valueOf(exception.getError().getHttpStatusCode())).body(new ErrorDTO(exception.getError().name(), exception.getError().getDetail()));
    }
}
