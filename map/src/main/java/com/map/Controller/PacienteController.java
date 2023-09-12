package com.map.Controller;

import com.map.Paciente.Paciente;
import com.map.Paciente.PacienteRepository;
import com.map.Paciente.dadosCadastroPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;
    @PostMapping
    public void cadastrarPaciente(@RequestBody dadosCadastroPaciente dados) {

        repository.save(new Paciente(dados));
    }
}
