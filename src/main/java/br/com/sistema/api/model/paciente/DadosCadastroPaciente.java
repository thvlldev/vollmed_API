package br.com.sistema.api.model.paciente;

import br.com.sistema.api.model.endereco.DadosCadastroEndereco;

// DTO do cadastro das informações do Paciente
public record DadosCadastroPaciente(
    String nome,
    String email,
    String telefone,
    DadosCadastroEndereco endereco
) {

    
}