package com.example.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username","message","JWT","status"})
public record AuthResponseDTO(String username,
                              String message,
                              String JWT,
                              boolean status) {

}
