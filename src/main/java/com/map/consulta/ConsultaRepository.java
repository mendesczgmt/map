package com.map.consulta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultaRepository extends JpaRepository <Consulta, Long>{
    Optional<Consulta> findById(Long id);
    void delete(Consulta consulta);
}


