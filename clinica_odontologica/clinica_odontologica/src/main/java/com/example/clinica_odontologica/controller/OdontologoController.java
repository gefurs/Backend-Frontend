package com.example.clinica_odontologica.controller;

import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.Odontologo;
import com.example.clinica_odontologica.model.OdontologoDTO;
import com.example.clinica_odontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologoDTO));
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscar(@PathVariable Long id){
        return odontologoService.leerOdontologo(id);
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> listarTodos() {
        return ResponseEntity.ok(odontologoService.leerTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarOdontologo(@PathVariable Long id) throws NotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Odontólogo eliminado");
    }

    @PutMapping()
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws NotFoundException {
        return ResponseEntity.ok(odontologoService.modificarOdontologo(odontologoDTO));
    }
}
