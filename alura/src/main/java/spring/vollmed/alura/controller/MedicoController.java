package spring.vollmed.alura.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import spring.vollmed.alura.medico.*;
import spring.vollmed.alura.medico.DadosCadastroMedico;


//Use este codigo SQL para erro no flyway:
//delete from flyway_schema_history where success = 0;

        //JSON que espera receber:
//{
//        "nome": "Teste ",
//        "email": "testan@voll.med",
//        "telefone": "11930283743",
//        "crm": "21313",
//        "especialidade": "CARDIOLOGIA",
//        "endereco": {
//        "logradouro": "rua 1",
//        "bairro": "bairro",
//        "cep": "12345678",
//        "cidade": "Brasília",
//        "uf": "DF",
//        "numero": "1",
//        "complemento": "complemtento"
//        }
//        }

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
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    //Excluir totalmente:

//    @DeleteMapping("{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id){
//        repository.deleteById(id);
//    }


    // Exlusão Lógica - Consiste em intativar o medico, e nao excluir totalmente
    @DeleteMapping("{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.Excluir();
    }
}
