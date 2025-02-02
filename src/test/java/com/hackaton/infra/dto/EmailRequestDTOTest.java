package com.hackaton.infra.dto;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class EmailRequestDTOTest {

    @Test
    public void testEmailRequestDTO() {
        // Criando um objeto usando o construtor completo
        EmailRequestDTO email = new EmailRequestDTO("test@example.com", "Test Subject", "Test Message");

        // Verificando os valores
        assertEquals("test@example.com", email.to());
        assertEquals("Test Subject", email.subject());
        assertEquals("Test Message", email.message());

        // Criando um objeto usando o construtor vazio e setters
        EmailRequestDTO emailEmpty = new EmailRequestDTO("user@example.com", "Hello", "This is a test.");


        // Verificando os valores
        assertEquals("user@example.com", emailEmpty.to());
        assertEquals("Hello", emailEmpty.subject());
        assertEquals("This is a test.", emailEmpty.message());
    }

}
