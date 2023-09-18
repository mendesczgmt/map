package com.map.Paciente;

public record DadosListagemPaciente(Long id, String nome, String telefone, String cpf, boolean ativo ) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getCPF(), paciente.getAtivo());
    }
}
