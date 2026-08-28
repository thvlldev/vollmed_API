package br.com.sistema.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Pra avisar que ela é um controlador! Registra ela como controller // quando for conectar com front end, usar @Controller
@RequestMapping("ola") //Define a url base para todos os métodos dessa classe
public class OlaController {

    // /olamundo
    @GetMapping("/olamundo") // Método HTTP do tipo GET
    public String olaMundo() {
        return "Olá, mundo! 😎😎😎😎 Filipe Trotte bilu teteia";
    }
}