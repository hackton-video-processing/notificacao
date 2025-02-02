package com.hackaton.infra.javaMail;

import com.hackaton.domain.interfaces.EmailInterface;
import com.hackaton.infra.dto.EmailRequestDTO;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JavaMailService implements EmailInterface {

    private final JavaMailSender mailSender;

    public JavaMailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailRequestDTO request) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(request.to());
        mailMessage.setSubject(request.subject());
        mailMessage.setText(request.message());

        mailSender.send(mailMessage);
    }
}
