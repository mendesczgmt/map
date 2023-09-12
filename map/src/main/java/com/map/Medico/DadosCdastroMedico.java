package com.map.Medico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCdastroMedico(
    @NotBlank
    String nome,
    @NotBlank
    @Email
    String email,
    @NotBlank
    String crm
    ) {

   

}


