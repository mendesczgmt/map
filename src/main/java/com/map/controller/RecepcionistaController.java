package com.map.controller;

import com.map.Recepcionista.DadosCadastroRecepcionista;
import com.map.Recepcionista.Recepcionista;
import com.map.Recepcionista.RecepcionistaRepository;
import com.map.Recepcionista.RecepcionistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/recepcionista")
public class RecepcionistaController {

    final RecepcionistaService recepcionistaService;

    public RecepcionistaController(RecepcionistaService recepcionistaService) {
        this.recepcionistaService = recepcionistaService;
    }

    @Autowired
    private RecepcionistaRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroRecepcionista dados){
        repository.save(new Recepcionista(dados));
    }

    @GetMapping
    public Page<DadosCadastroRecepcionista> listarRecepcionistas(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosCadastroRecepcionista::new);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Object> getRecepcionistaById(@PathVariable(value = "id") Long id) {
        Optional<Recepcionista> recepcionistaOptional = recepcionistaService.findById(id);
        if (recepcionistaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recepcionista not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(recepcionistaOptional.get());
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRecepcionista(@PathVariable(value = "id") Long id) {
        Optional<Recepcionista> recepcionistaOptional = recepcionistaService.findById(id);
        if (recepcionistaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recepcionista not found.");
        }
        recepcionistaService.Delete(recepcionistaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Recepcionista deleted successfully.");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateRecepcionista(@PathVariable(value = "id") Long id, @RequestBody Map<Object, Object> objectMap) {
        Optional<Recepcionista> recepcionistaOptional = recepcionistaService.findById(id);
        if (recepcionistaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recepcionista not found.");
        }
        recepcionistaService.partialUpdate(recepcionistaOptional.get(), objectMap);
        return ResponseEntity.status(HttpStatus.OK).body("Recepcionista updated successfully.");
    }

}
