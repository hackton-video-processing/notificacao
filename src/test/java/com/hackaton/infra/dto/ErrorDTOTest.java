package com.hackaton.infra.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorDTOTest {

    @Test
    void errorDTOCreationWithValidData() {
        ErrorDTO errorDTO = new ErrorDTO("404", "Not Found");

        assertNotNull(errorDTO);
        assertEquals("404", errorDTO.code());
        assertEquals("Not Found", errorDTO.detail());
    }

    @Test
    void errorDTOCreationWithEmptyCode() {
        ErrorDTO errorDTO = new ErrorDTO("", "Detail message");

        assertNotNull(errorDTO);
        assertEquals("", errorDTO.code());
        assertEquals("Detail message", errorDTO.detail());
    }

    @Test
    void errorDTOCreationWithEmptyDetail() {
        ErrorDTO errorDTO = new ErrorDTO("500", "");

        assertNotNull(errorDTO);
        assertEquals("500", errorDTO.code());
        assertEquals("", errorDTO.detail());
    }

    @Test
    void errorDTOCreationWithNullCode() {
        ErrorDTO errorDTO = new ErrorDTO(null, "Detail message");

        assertNotNull(errorDTO);
        assertNull(errorDTO.code());
        assertEquals("Detail message", errorDTO.detail());
    }

    @Test
    void errorDTOCreationWithNullDetail() {
        ErrorDTO errorDTO = new ErrorDTO("500", null);

        assertNotNull(errorDTO);
        assertEquals("500", errorDTO.code());
        assertNull(errorDTO.detail());
    }

}