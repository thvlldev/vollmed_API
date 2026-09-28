package br.com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.api.model.medico.DadosAtualizacaoMedico;
import br.com.sistema.api.model.medico.DadosCadastroMedico;
import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.paciente.DadosAtualizacaoPaciente;
import br.com.sistema.api.model.paciente.DadosCadastroPaciente;
import br.com.sistema.api.model.paciente.Paciente;
import br.com.sistema.api.model.paciente.PacienteRepository;
import jakarta.transaction.Transactional;

@RestController //Registra como controlador!
@RequestMapping("paciente")
public class PacienteController {


    @Autowired 
    private PacienteRepository pacienteRepository;

    //CRUD
    @PostMapping("/cadastro")
    @Transactional 
    public void cadastrarPaciente(@RequestBody  DadosCadastroPaciente dados) { //Com @RequestBody, ele vai entender tudo como String, e não como objeto ou JSON, não trabalhamos com dados assim 
        pacienteRepository.save(new Paciente(dados));   
    }

    // GET Request -> Response -> Ex: Tela home
    @GetMapping("/listar-todos") // Aponta para localhost:8080/medico
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // DELETE - Exclusão real
    @DeleteMapping("/deletar/{id}") // Aponta para localhost:8080/medico/deletar/{id}
    @Transactional
    public void excluir(@PathVariable Integer  id) {
        pacienteRepository.deleteById(id);
    }

    // DELETE - Exclusão lógica
    @DeleteMapping("/alterar-status/{id}")
    @Transactional 
    public void alterarStatus(@PathVariable Integer id) {
        var paciente = pacienteRepository.getReferenceById(id); // O var está sendo utilizado para que assim que o id for chamado e acessado, eu pegue todos os atributos e guarde agora no objeto medico. 
        paciente.excluirLogico();
    }

    // PUT
    @PutMapping("/atualizar")
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }   


    


    //post
    //put
    //delete



    //crud


    
    
}

// CRUD