package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade) {

        public DadosCadastroMedico(Medico medico){
            this(medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade());
        }
}
