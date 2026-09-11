package br.com.sistema.api.model.medico;

import br.com.sistema.api.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;


//@Entity -> tem que chamar uma dependencia do spring boot para JPA

@Entity
@Table(name = "Medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded // Utilizando na classe que representa a tabela principal no BD
    private Endereco endereco;

    // Método Construtor recebendo o DTO DadosCadastroMedico e conectando a um objeto médico
    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());        
    }
   
}