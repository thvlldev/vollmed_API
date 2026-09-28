package br.com.sistema.api.model.consulta;

import java.time.LocalDateTime;

//Classe DTO que recebe os dados que vão vir do Imsonia, armazenar, fazer a conversão

public record DadosAgendamentoConsulta(
    Integer medicoId,
    Integer pacienteId,
    String observacao,
    Status status,
    LocalDateTime data
) {
    
}
