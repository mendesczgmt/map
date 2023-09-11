package com.map.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.Medico.DadosCdastroMedico;

@RestController
@RequestMapping("medicos")
public class MedicoController {

   @PostMapping
   public void cadastrar(@RequestBody DadosCdastroMedico dados) {
    System.out.println(dados);

   }


}