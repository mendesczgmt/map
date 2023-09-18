package com.map.agenda;

import java.time.LocalTime;


import jakarta.validation.constraints.NotNull;

public record AgendaDto (
    @NotNull
    LocalTime hora_inicio,
    @NotNull
    LocalTime hora_termino) {
}
