package br.com.sistema.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.sistema.api.model.consulta.Consulta;
import br.com.sistema.api.model.consulta.ConsultaRepository;
import br.com.sistema.api.model.consulta.DadosAgendamentoConsulta;
import br.com.sistema.api.model.medico.MedicoRepository;
import br.com.sistema.api.model.paciente.PacienteRepository;
import jakarta.transaction.Transactional;

@RestController 
@RequestMapping("/consultas") 
public class ConsultaController {

    @Autowired 
    private ConsultaRepository consultaRepository;

    @Autowired 
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;



    // POST
    @PostMapping 
    @Transactional
    public Consulta agendar(@RequestBody DadosAgendamentoConsulta dados) {
        var medico = medicoRepository.getReferenceById(dados.medicoId());
        var paciente = pacienteRepository.getReferenceById(dados.pacienteId());
        var consulta = new Consulta(dados, medico, paciente);

        return consultaRepository.save(consulta);

    }


}

/**
 * var significa que o tipo da variável ainda não foi definida. Com isso, a var irá receber o tipo do objeto. Var é uma palavra chave que está disponível a partir da versão 10 do java. O compilador infere o tipo  dessa variável com base no valor atribuído a ela.
 */
