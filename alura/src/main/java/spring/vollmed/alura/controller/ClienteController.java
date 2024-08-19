package spring.vollmed.alura.controller;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.vollmed.alura.cliente.DadosCadastroCliente;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados){
        System.out.println(dados);
    }
}
