package com.hackaton.domain.interfaces;

import com.hackaton.infra.dto.EmailRequestDTO;

public interface EmailInterface {

    void sendEmail(EmailRequestDTO request);
}
