package com.map.medico;

import com.map.agenda.Agenda;

public record DadosListagemMedico(Long id, String nome, Especialidade especialidade, Agenda agenda){
    
    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEspecialidade(), medico.getAgenda());
    }
}
