package com.example.clinica_odontologica.controller.login;

import com.example.clinica_odontologica.service.login.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String home() {
        return "<h1> Bienvenidos </h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1> Bienvenido Usuario </h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1> Bienvenido Administrador </h1>";
    }

}
