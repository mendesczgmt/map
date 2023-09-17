package com.map.controller;

import com.map.medico.DadosCadastroMedico;
import com.map.medico.DadosListagemMedico;
import com.map.medico.Medico;
import com.map.medico.MedicoRepository;
import com.map.medico.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico medico){
        repository.save(new Medico(medico));
    }

     @GetMapping
    public Page<DadosListagemMedico> listarMedicos(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Object> getMedicoById(@PathVariable(value = "id") Long id) {
        Optional<Medico> medicoOptional = medicoService.findById(id);
        if (medicoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicoOptional.get());
    } 

     @GetMapping("/nome")
    public ResponseEntity<List<Medico>> getMedicoByName(@Validated @RequestParam(value = "name") String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.findByName(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMedico(@PathVariable(value = "id") Long id) {
        Optional<Medico> medicoOptional = medicoService.findById(id);
        if (medicoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico not found.");
        }
        medicoService.Delete(medicoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Medico deleted successfully.");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateMedico(@PathVariable(value = "id") Long id, @RequestBody Map<Object, Object> objectMap) {
        Optional<Medico> medicoOptional = medicoService.findById(id);
        if (medicoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico not found.");
        }
        medicoService.partialUpdate(medicoOptional.get(), objectMap);
        return ResponseEntity.status(HttpStatus.OK).body("Medico updated successfully.");
    }




}
