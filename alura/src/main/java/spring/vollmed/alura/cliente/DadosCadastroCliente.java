package spring.vollmed.alura.cliente;

import spring.vollmed.alura.endereco.DadosEndereco;

public record DadosCadastroCliente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
}
