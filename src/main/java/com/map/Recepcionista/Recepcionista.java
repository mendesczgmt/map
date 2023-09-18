package com.map.Recepcionista;

import jakarta.persistence.*;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "recepcionistas")
@Entity(name = "Recepcionista")
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Recepcionista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;


    public Recepcionista(DadosCadastroRecepcionista dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
    }
}