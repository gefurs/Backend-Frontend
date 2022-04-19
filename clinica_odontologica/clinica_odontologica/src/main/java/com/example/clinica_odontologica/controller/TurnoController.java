package com.example.clinica_odontologica.controller;

import com.example.clinica_odontologica.exceptions.BadRequestException;
import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.Turno;
import com.example.clinica_odontologica.model.TurnoDTO;
import com.example.clinica_odontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Turno> crearTurno(@RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        return ResponseEntity.ok(turnoService.crearTurno(turnoDTO));
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDTO>>listarTurnos(){
        return ResponseEntity.ok(turnoService.leerTodos());
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarTurno(@PathVariable Long id){
        return turnoService.leerTurno(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTurno(@PathVariable Long id) throws NotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Turno eliminado");
    }

    @PutMapping()
    public ResponseEntity<Turno> modificarTurno(@RequestBody TurnoDTO turnoDTO) throws NotFoundException {
        return ResponseEntity.ok(turnoService.modificarTurno(turnoDTO));
    }

}

