package spring.vollmed.alura.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import spring.vollmed.alura.endereco.Endereco;

@Data
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
@Entity(name = "Medico")
public class Medico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;


    public Medico(){

    }

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();
    }

    public void atualizarInformacoes(@Valid DadosAtualizarMedico dados) {

        if (dados.nome() != null){
            this.nome = dados.nome();
        }

        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void Excluir() {
        this.ativo = false;
    }
}
