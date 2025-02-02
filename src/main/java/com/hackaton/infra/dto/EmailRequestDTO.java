package com.hackaton.infra.dto;


public record EmailRequestDTO(String to, String subject, String message) {}
