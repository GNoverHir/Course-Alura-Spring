package spring.vollmed.alura.medico;

import spring.vollmed.alura.endereco.Endereco;

public record DadosDetalhadosMedico(Long id, String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhadosMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
