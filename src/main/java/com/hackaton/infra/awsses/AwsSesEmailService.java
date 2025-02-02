package com.hackaton.infra.awsses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.hackaton.domain.interfaces.EmailInterface;
import com.hackaton.infra.dto.EmailRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AwsSesEmailService implements EmailInterface {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Value("${aws.ses.sender}")
    private String sender;

    public AwsSesEmailService(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(EmailRequestDTO request) {

        SendEmailRequest sendEmailRequest = new SendEmailRequest()
                .withSource(sender)
                .withDestination(new Destination().withToAddresses(request.getTo()))
                .withMessage(new Message().withSubject(new Content(request.getSubject()))
                .withBody(new Body().withText(new Content(request.getMessage()))));

        this.amazonSimpleEmailService.sendEmail(sendEmailRequest);
    }
}
