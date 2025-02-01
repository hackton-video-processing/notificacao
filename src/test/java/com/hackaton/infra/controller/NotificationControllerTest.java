package com.hackaton.infra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackaton.application.usecases.NotificationUseCases;
import com.hackaton.infra.dto.NotificationRequestDTO;
import com.hackaton.infra.handler.NotificationAdvice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class NotificationControllerTest {

    @Mock
    private NotificationUseCases useCases;

    private MockMvc mockMvc;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        var notificationController = new NotificationController(useCases);
        mockMvc = MockMvcBuilders.standaloneSetup(notificationController)
                .setControllerAdvice(new NotificationAdvice())
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void sendNotification() throws Exception {

        var notificationRequestDTO = new NotificationRequestDTO("test@test.com", "testing");

        doNothing().when(useCases).sendNotification(notificationRequestDTO);

        mockMvc.perform(post("/notification")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(notificationRequestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Notification sent successfully"));
    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}