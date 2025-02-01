package com.hackaton.infra.resource;

import com.hackaton.infra.dto.ErrorDTO;
import com.hackaton.infra.dto.NotificationRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/notification")
@Tag(name = "Notification", description = "Resources related to notification")
public interface NotificationResource {

    @Operation(summary = "Save the notification", method = "POST", description = "Resource to save a notification")
    @ApiResponses(value = {
            @ApiResponse(description = "Notification saved successfully", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Error saving notification", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> sendNotification(@RequestBody NotificationRequestDTO request);

}
