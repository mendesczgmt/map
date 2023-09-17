package com.map.agenda;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Agenda {
    
    private String hora_inicio;
    private String hora_termino;

    public Agenda(AgendaDto dados){
        this.hora_inicio = dados.hora_inicio();
        this.hora_termino = dados.hora_termino();
    }
    


}
