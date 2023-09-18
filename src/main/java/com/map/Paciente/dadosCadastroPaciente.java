package com.map.Paciente;

import jakarta.validation.constraints.NotBlank;

public record dadosCadastroPaciente(
    @NotBlank
    String nome, 
    @NotBlank
    String telefone,
    @NotBlank
    String CPF,
    @NotBlank
    String data_nasc,
    @NotBlank
    int idade) {
}
