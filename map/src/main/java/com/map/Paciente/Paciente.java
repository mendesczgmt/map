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

    public Paciente(dadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.CPF = dados.CPF();
        this.data_nasc = dados.data_nasc();
        this.idade = dados.idade();
    }
}
