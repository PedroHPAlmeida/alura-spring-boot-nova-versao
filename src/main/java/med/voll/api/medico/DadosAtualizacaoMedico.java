package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
