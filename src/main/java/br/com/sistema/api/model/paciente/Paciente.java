package br.com.sistema.api.model.paciente;

import br.com.sistema.api.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = "id")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Boolean ativo = true;

    @Embedded // Utilizando na classe que representa a tabela principal no BD
    private Endereco endereco;


        // Método Construtor recebendo o DTO DadosCadastrPaciente e conectando a um objeto Paciente
    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());        
    }

    // Método para alterar o status do campo ativo
    public void excluirLogico() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

}
