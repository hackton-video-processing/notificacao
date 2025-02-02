package com.hackaton.infra.dto;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class EmailRequestDTOTest {

    @Test
    public void testEmailRequestDTO() {
        // Criando um objeto usando o construtor completo
        EmailRequestDTO email = new EmailRequestDTO("test@example.com", "Test Subject", "Test Message");

        // Verificando os valores
        assertEquals("test@example.com", email.getTo());
        assertEquals("Test Subject", email.getSubject());
        assertEquals("Test Message", email.getMessage());

        // Criando um objeto usando o construtor vazio e setters
        EmailRequestDTO emailEmpty = new EmailRequestDTO();
        emailEmpty.setTo("user@example.com");
        emailEmpty.setSubject("Hello");
        emailEmpty.setMessage("This is a test.");

        // Verificando os valores
        assertEquals("user@example.com", emailEmpty.getTo());
        assertEquals("Hello", emailEmpty.getSubject());
        assertEquals("This is a test.", emailEmpty.getMessage());
    }

}
