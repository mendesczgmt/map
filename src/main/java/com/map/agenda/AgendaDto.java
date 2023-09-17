package com.map.agenda;

import jakarta.validation.constraints.NotBlank;

public record AgendaDto (
    @NotBlank
    String hora_inicio,
    @NotBlank 
    String hora_termino) {
    
}
