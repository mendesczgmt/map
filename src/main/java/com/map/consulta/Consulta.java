package com.map.consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

import com.map.Paciente.Paciente;
import com.map.Recepcionista.Recepcionista;
import com.map.medico.Medico;


@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Recepcionista recepcionista;
    
    public Consulta(DadosCadastroConsulta dados) {
        this.data = dados.data();
        this.hora = dados.hora();
        this.medico = dados.medico();
        this.paciente = dados.paciente();
        this.recepcionista = dados.recepcionista();
    }



}
