package com.map.Paciente;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String cpf,
        String telefone,
        String data_nasc) {

}
