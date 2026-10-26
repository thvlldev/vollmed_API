package br.com.sistema.api.model.consulta;

import java.time.LocalDateTime;

import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table (name = "consultas")
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String observacao;


    @ManyToOne 
    @JoinColumn(name = "pacienteId")
    private Paciente paciente;

    @ManyToOne
    private Medico medico;


    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Terceiro construtor da classe Consulta que recebe a conversão do DadosAgendamentoConsulta
    // O this.medico = new Medico() cria um objeto de médico vazio. Quando você tentar inserir o id nesse novo médico crado, ele irá receber e o BD saberá que aquele id já existe e trará as informações com o id daquele médico.
    public Consulta(DadosAgendamentoConsulta dados) {
        this.medico = new Medico();
        this.medico.setId(dados.medicoId());
        this.paciente = new Paciente();
        this.paciente.setId(dados.pacienteId());
        this.status = dados.status();
        this.observacao = dados.observacao();
        this.data = dados.data();
    }

    

}


// @ManyToOne 
// => Relacionamento N:1 -> Muitas consultas podem ter o mesmo Médico.
// => Sempre o primeiro termo é referente a tabela atual, o segundo termo a tabela de referência.
