package spring.vollmed.alura.cliente;

import jakarta.validation.constraints.NotNull;
import spring.vollmed.alura.endereco.DadosEndereco;

public record DadosAtualizarCliente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
