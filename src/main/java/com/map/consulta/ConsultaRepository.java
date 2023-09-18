package com.map.consulta;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.map.medico.Medico;

public interface ConsultaRepository extends JpaRepository <Consulta, Long>{
    Optional<Consulta> findById(Long id);
    void delete(Consulta consulta);
    @Query("SELECT c FROM Consulta c WHERE c.medico = :medico AND c.hora = :hora")
    List<Consulta> findByMedicoAndHora(@Param("medico") Medico medico, @Param("hora") LocalTime hora);
}


