package com.map.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.Medico.DadosCdastroMedico;
import com.map.Medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

   @PostMapping
   public void cadastrar(@RequestBody DadosCdastroMedico dados) {
    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody werember.api.user.DadosCadastroUser dados) {
      repository.save(new Medico(dados));
    };
   }


}