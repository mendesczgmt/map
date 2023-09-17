package com.map.medico;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

@Service
public class MedicoService {
    
    final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    //CONSULTAS
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> findById(Long id){
        return medicoRepository.findById(id);
    }

    public List<Medico> findByName(String nome) {
        return medicoRepository.findByName(nome);
    }

    //DELETE
    @Transactional
    public void Delete(Medico medico) {
        medicoRepository.delete(medico);
    }

    //UPDATE

    public Medico partialUpdate(Medico medico, Map<Object, Object> objectMap) {
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Medico.class, (String) key);
            field.setAccessible(true);

            try {
                value = BigDecimal.valueOf((double) value);
            }
            catch(ClassCastException ignored) { }
            ReflectionUtils.setField(field, medico, value);
        });
        return medicoRepository.save(medico);
    }
}