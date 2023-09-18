package com.map.agenda;

import java.time.LocalTime;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Agenda {
    
    private LocalTime hora_inicio;
    private LocalTime hora_termino;

    public Agenda(AgendaDto dados){
        this.hora_inicio = dados.hora_inicio();
        this.hora_termino = dados.hora_termino();
    }
    


}
