package spring.vollmed.alura.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import spring.vollmed.alura.cliente.Cliente;
import spring.vollmed.alura.cliente.ClienteRepository;
import spring.vollmed.alura.cliente.DadosCadastroCliente;
import spring.vollmed.alura.cliente.DadosListagemCliente;
import spring.vollmed.alura.medico.DadosListagemMedico;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados){
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<DadosListagemCliente> listar(@PageableDefault(size = 10, sort = {"cpf"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCliente::new);
    }
}
