package com.map.consulta;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.map.medico.Medico;

import jakarta.validation.Valid;


@Service
public class ConsultaService {

    final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

    @Transactional
    public void marcarConsulta(@RequestBody @Valid DadosCadastroConsulta consulta){
        consultaRepository.save(new Consulta(consulta));
    }

    public boolean existeConsultaNoMesmoHorario(Medico medico, LocalTime hora) {
        List<Consulta> consultasConflitantes = consultaRepository.findByMedicoAndHora(medico, hora);
        return !consultasConflitantes.isEmpty();
    }

    //CONSULTAS
    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> findById(Long id){
        return consultaRepository.findById(id);
    }

    //DELETE
    @Transactional
    public void Delete(Consulta consulta) {
        consultaRepository.delete(consulta);
    }

    //UPDATE

    public Consulta partialUpdate(Consulta consulta, Map<Object, Object> objectMap) {
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Consulta.class, (String) key);
            field.setAccessible(true);

            try {
                value = BigDecimal.valueOf((double) value);
            }
            catch(ClassCastException ignored) { }
            ReflectionUtils.setField(field, consulta, value);
        });
        return consultaRepository.save(consulta);
    }
}
