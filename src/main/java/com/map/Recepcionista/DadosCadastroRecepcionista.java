package com.map.Recepcionista;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRecepcionista(

        @NotBlank
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String telefone) {

    public DadosCadastroRecepcionista(Recepcionista recepcionista){
        this(recepcionista.getId(),recepcionista.getNome(), recepcionista.getTelefone());
    }


}
