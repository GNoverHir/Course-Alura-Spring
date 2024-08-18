package spring.vollmed.alura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import spring.vollmed.alura.medico.DadosCadastroMedico;
import spring.vollmed.alura.medico.DadosCadastroMedico;
import spring.vollmed.alura.medico.Medico;
import spring.vollmed.alura.medico.MedicoRepository;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

}
