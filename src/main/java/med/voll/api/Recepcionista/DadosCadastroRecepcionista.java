package med.voll.api.Recepcionista;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRecepcionista(

        @NotBlank
        String nome,
        @NotBlank
        String telefone) {

    public DadosCadastroRecepcionista(Recepcionista recepcionista){
        this(recepcionista.getNome(), recepcionista.getTelefone());
    }


}
