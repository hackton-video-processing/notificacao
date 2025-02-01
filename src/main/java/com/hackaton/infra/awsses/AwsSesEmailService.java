package com.hackaton.infra.awsses;

import com.hackaton.domain.interfaces.EmailInterface;
import com.hackaton.infra.dto.EmailRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Service
@ConditionalOnProperty(name = "email.provider", havingValue = "aws")
public class AwsSesEmailService implements EmailInterface {

    private final SesClient sesClient;

    @Value("${aws.ses.sender}")
    private String sender;

    public AwsSesEmailService(SesClient sesClient) {
        this.sesClient = sesClient;
    }

    @Override
    public void sendEmail(EmailRequestDTO request) {
        SendEmailRequest emailRequest = SendEmailRequest.builder()
                .source(sender)
                .destination(Destination.builder().toAddresses(request.getTo()).build())
                .message(Message.builder()
                        .subject(Content.builder().data(request.getSubject()).build())
                        .body(Body.builder().text(Content.builder().data(request.getMessage()).build()).build())
                        .build())
                .build();

        sesClient.sendEmail(emailRequest);
    }
}
