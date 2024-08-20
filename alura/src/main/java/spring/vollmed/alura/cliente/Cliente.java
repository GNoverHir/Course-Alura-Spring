package spring.vollmed.alura.cliente;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import spring.vollmed.alura.endereco.Endereco;

@Data
@EqualsAndHashCode(of = "id")
@Table(name = "clientes")
@Entity(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }
}
