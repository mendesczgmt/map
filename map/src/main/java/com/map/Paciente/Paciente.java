package com.map.Paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String CPF;
    private String data_nasc;
    private int idade;

    private boolean ativo;

    public Paciente(dadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.CPF = dados.CPF();
        this.data_nasc = dados.data_nasc();
        this.idade = dados.idade();
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public int getIdade() {
        return idade;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.cpf() != null) {
            this.CPF = dados.cpf();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.data_nasc() != null) {
            this.data_nasc = dados.data_nasc();
        }
    }


    public void excluir() {
        this.ativo = false;
    }
}
