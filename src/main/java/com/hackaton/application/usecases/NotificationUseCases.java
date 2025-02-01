package com.hackaton.application.usecases;

import com.hackaton.domain.enums.NotificationErrorEnum;
import com.hackaton.domain.exceptions.NotificationException;
import com.hackaton.domain.interfaces.EmailInterface;
import com.hackaton.infra.dto.EmailRequestDTO;
import com.hackaton.infra.dto.NotificationRequestDTO;


public class NotificationUseCases {

    private final EmailInterface emailInterface;

    public NotificationUseCases(EmailInterface emailInterface) {
        this.emailInterface = emailInterface;
    }

    public void sendNotification(NotificationRequestDTO request) {
        try{
            emailInterface.sendEmail(new EmailRequestDTO(request.userEmail(), "Notification - hackaton", request.message()));
        } catch (Exception e){
            throw new NotificationException(NotificationErrorEnum.ERROR_TO_SEND_EMAIL);
        }
    }
}
