package java.com.map.Recepcionista;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Long> {
    Optional<Recepcionista> findById(Long id);
    void delete(Recepcionista recepcionista);
}
