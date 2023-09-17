package med.voll.api.controller;

import med.voll.api.Recepcionista.DadosCadastroRecepcionista;
import med.voll.api.Recepcionista.Recepcionista;
import med.voll.api.Recepcionista.RecepcionistaRepository;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recepcionista")
public class RecepcionistaController {

    @Autowired
    private RecepcionistaRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroRecepcionista dados){
        repository.save(new Recepcionista(dados));
    }

    @GetMapping
    public List<DadosCadastroRecepcionista> listarMedicos(){
        return repository.findAll().stream().map(DadosCadastroRecepcionista::new).toList();
    }



}
