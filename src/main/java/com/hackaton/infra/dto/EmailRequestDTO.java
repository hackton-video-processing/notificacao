package com.hackaton.infra.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequestDTO {

    @NotBlank @Email
    String to;

    @NotBlank
    String subject;

    @NotBlank
    String message;
}
