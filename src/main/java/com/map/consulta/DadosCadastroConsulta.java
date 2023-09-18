package com.map.consulta;

import java.time.LocalDate;
import java.time.LocalTime;

import com.map.Paciente.Paciente;
import com.map.Recepcionista.Recepcionista;
import com.map.medico.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroConsulta(
    Long id,
    @NotNull
    LocalDate data,
    @NotNull
    LocalTime hora,
    @Valid 
    Medico medico,
    @Valid
    Paciente paciente,
    @Valid
    Recepcionista recepcionista

) {
    public DadosCadastroConsulta(Consulta consulta){
        this(consulta.getId(),consulta.getData(), consulta.getHora(), consulta.getMedico(), consulta.getPaciente(), consulta.getRecepcionista());
    }
}
