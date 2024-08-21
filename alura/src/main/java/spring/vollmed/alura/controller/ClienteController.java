package spring.vollmed.alura.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import spring.vollmed.alura.cliente.*;
import spring.vollmed.alura.medico.DadosAtualizarMedico;
import spring.vollmed.alura.medico.DadosListagemMedico;


//Use este codigo SQL para erro no flyway:
//delete from flyway_schema_history where success = 0;


    //JSON que espera receber:
//    {
//        "nome": "jagunçõ ",
//            "email": "jagunço@voll.med",
//            "telefone": "389274028",
//            "cpf": "39028174921",
//            "endereco": {
//                  "logradouro": "rua 1",
//                  "bairro": "bairro",
//                  "cep": "12345678",
//                  "cidade": "Brasília",
//                  "uf": "DF",
//                  "numero": "1",
//                  "complemento": "complemtento"
//    }
//    }

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
    public Page<DadosListagemCliente> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.Excluir();
    }
}
