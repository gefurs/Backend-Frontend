package com.example.clinica_odontologica.login;

import com.example.clinica_odontologica.model.login.Usuario;
import com.example.clinica_odontologica.repository.impl.login.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String userPassword = passwordEncoder.encode("passwordu");
        String adminPassword = passwordEncoder.encode("passworda");

        Usuario usuario = new Usuario("Viviana Sanchez", "user1", "viviana_sanchez@gmail.com", userPassword, UsuarioRoles.USER);
        Usuario administrador = new Usuario("Javier Diaz", "admin1", "javier_diaz@gmail.com", adminPassword, UsuarioRoles.ADMIN);
        usuarioRepository.save(usuario);
        usuarioRepository.save(administrador);
    }
}
