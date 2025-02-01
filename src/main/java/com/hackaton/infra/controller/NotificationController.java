package com.hackaton.infra.controller;

import com.hackaton.application.usecases.NotificationUseCases;
import com.hackaton.infra.dto.NotificationRequestDTO;
import com.hackaton.infra.resource.NotificationResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class NotificationController implements NotificationResource {

    private final NotificationUseCases useCases;

    public NotificationController(NotificationUseCases useCases) {
        this.useCases = useCases;
    }

    @Override
    public ResponseEntity<Object> sendNotification(NotificationRequestDTO request) {
        useCases.sendNotification(request);
        return ResponseEntity.ok("Notification sent successfully");
    }
}
