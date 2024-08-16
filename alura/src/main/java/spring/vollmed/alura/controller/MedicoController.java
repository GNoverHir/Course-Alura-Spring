package spring.vollmed.alura.controller;

import org.springframework.web.bind.annotation.*;
import spring.vollmed.alura.medico.DadosCadastroMedico;
import spring.vollmed.alura.medico.DadosCadastroMedico;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        System.out.println(dados);
    }

}
