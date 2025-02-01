package com.hackaton.infra.smtp;

import com.hackaton.domain.interfaces.EmailInterface;
import com.hackaton.infra.dto.EmailRequestDTO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "email.provider", havingValue = "smtp")
public class SmtpEmailService implements EmailInterface {

    private final JavaMailSender mailSender;

    public SmtpEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailRequestDTO request) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(request.getTo());
        mailMessage.setSubject(request.getSubject());
        mailMessage.setText(request.getMessage());

        mailSender.send(mailMessage);
    }
}
