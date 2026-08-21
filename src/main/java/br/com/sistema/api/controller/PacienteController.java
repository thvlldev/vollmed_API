package br.com.sistema.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Registra como controlador!
@RequestMapping("paciente")
public class PacienteController {

    //get
    @GetMapping("/") // Aponta para localhost:8080/paciente

    public String exibirHome() { 
        return "a";
    }


    //post
    //put
    //delete



    //crud


    
    
}

// CRUD