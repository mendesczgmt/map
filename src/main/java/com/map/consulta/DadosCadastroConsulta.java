package com.map.consulta;

import com.map.Paciente.Paciente;
import com.map.Recepcionista.Recepcionista;
import com.map.medico.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroConsulta(
    Long id,
    @NotBlank
    String data,
    @NotBlank
    String hora,
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
