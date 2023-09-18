package com.map.Paciente;

public record DadosListagemPaciente(String nome, String telefone, String cpf, boolean ativo ) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getTelefone(), paciente.getCPF(), paciente.getAtivo());
    }
}
