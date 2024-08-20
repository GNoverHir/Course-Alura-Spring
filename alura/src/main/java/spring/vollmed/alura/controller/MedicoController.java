package spring.vollmed.alura.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import spring.vollmed.alura.cliente.DadosCadastroCliente;
import spring.vollmed.alura.medico.*;
import spring.vollmed.alura.medico.DadosCadastroMedico;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedico> Listar(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

}
