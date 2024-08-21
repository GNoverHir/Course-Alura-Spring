package spring.vollmed.alura.medico;

import jakarta.validation.constraints.NotNull;
import spring.vollmed.alura.endereco.DadosEndereco;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
