package com.map.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.map.consulta.Consulta;
import com.map.consulta.ConsultaRepository;
import com.map.consulta.ConsultaService;
import com.map.consulta.DadosCadastroConsulta;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarConsulta(@RequestBody @Valid DadosCadastroConsulta consulta){
        repository.save(new Consulta(consulta));
    }

     @GetMapping
    public Page<DadosCadastroConsulta> listarConsultas(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosCadastroConsulta::new);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Object> getConsultaById(@PathVariable(value = "id") Long id) {
        Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (consultaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(consultaOptional.get());
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteConsulta(@PathVariable(value = "id") Long id) {
        Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (consultaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta not found.");
        }
        consultaService.Delete(consultaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Consulta deleted successfully.");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateconsulta(@PathVariable(value = "id") Long id, @RequestBody Map<Object, Object> objectMap) {
        Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (consultaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta not found.");
        }
        consultaService.partialUpdate(consultaOptional.get(), objectMap);
        return ResponseEntity.status(HttpStatus.OK).body("Consulta updated successfully.");
    }
}
