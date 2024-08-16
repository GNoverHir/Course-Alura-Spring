package spring.vollmed.alura.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.vollmed.alura.cliente.DadosCadastroCliente;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroCliente dados){
        System.out.println(dados);
    }
}
