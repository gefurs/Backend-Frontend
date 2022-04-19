package com.example.clinica_odontologica.controller;

import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.Paciente;
import com.example.clinica_odontologica.model.PacienteDTO;
import com.example.clinica_odontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.crearPaciente(pacienteDTO));
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPorId(@PathVariable Long id){
        return pacienteService.leerPaciente(id);
    }

    @GetMapping
    public ResponseEntity<Set<PacienteDTO>> listarTodos() {
        return ResponseEntity.ok(pacienteService.leerTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPaciente(@PathVariable Long id) throws NotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("Paciente eliminado");
    }

    @PutMapping()
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) throws NotFoundException {
        return ResponseEntity.ok(pacienteService.modificarPaciente(pacienteDTO));
    }

}
