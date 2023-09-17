package java.com.map.Recepcionista;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

@Service
public class RecepcionistaService {
    final RecepcionistaRepository recepcionistaRepository;

    public RecepcionistaService(RecepcionistaRepository RecepcionistaRepository){
        this.recepcionistaRepository = RecepcionistaRepository;
    }

    //CONSULTAS
    public List<Recepcionista> findAll() {
        return recepcionistaRepository.findAll();
    }

    public Optional<Recepcionista> findById(Long id){
        return recepcionistaRepository.findById(id);
    }

    //DELETE
    @Transactional
    public void Delete(Recepcionista recepcionista) {
        recepcionistaRepository.delete(recepcionista);
    }

    //UPDATE

    public Recepcionista partialUpdate(Recepcionista recepcionista, Map<Object, Object> objectMap) {
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Recepcionista.class, (String) key);
            field.setAccessible(true);

            try {
                value = BigDecimal.valueOf((double) value);
            }
            catch(ClassCastException ignored) { }
            ReflectionUtils.setField(field, recepcionista, value);
        });
        return recepcionistaRepository.save(recepcionista);
    }
}
