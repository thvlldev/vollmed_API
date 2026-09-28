package br.com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.sistema.api.model.medico.DadosAtualizacaoMedico;
import br.com.sistema.api.model.medico.DadosCadastroMedico;
import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.medico.MedicoRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("medico") //endpoint é sempre o nome. Já os métodos você sempre usa "/"
public class MedicoController {


    @Autowired  // É tipo o inject do Angular!
    private MedicoRepository medicoRepository;


    // CRUD 
    @PostMapping("/cadastro") 
    @Transactional 
    public void cadastrarMedico(@RequestBody  DadosCadastroMedico dados) { //Com @RequestBody, ele vai entender tudo como String, e não como objeto ou JSON, não trabalhamos com dados assim 
        medicoRepository.save(new Medico(dados));   
    }
    
    // GET Request -> Response -> Ex: Tela home
    @GetMapping("/listar-todos") // Aponta para localhost:8080/medico
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    // GET/POST Request -> Response -> Ex: Cadastrar Medico. GET Exibe tela de cadastro e o POST é chamado quando o botão enviar é clicado.
   
    // GET/PUT Request -> Response -> Ex: Alterar telefone. Get exibe a tela de alteração e o PUT é chamado quando o botão alterar é clicado.

    
    // DELETE - Exclusão real
    @DeleteMapping("/deletar/{id}") // Aponta para localhost:8080/medico/deletar/{id}
    @Transactional
    public void excluir(@PathVariable Integer  id) {
        medicoRepository.deleteById(id);
    }

    // DELETE - Exclusão lógica
    @DeleteMapping("/alterar-status/{id}")
    @Transactional 
    public void alterarStatus(@PathVariable Integer id) {
        var medico = medicoRepository.getReferenceById(id); // O var está sendo utilizado para que assim que o id for chamado e acessado, eu pegue todos os atributos e guarde agora no objeto medico. 
        medico.excluirLogico();
    }

    // PUT
    @PutMapping("/atualizar")
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }



}
    
