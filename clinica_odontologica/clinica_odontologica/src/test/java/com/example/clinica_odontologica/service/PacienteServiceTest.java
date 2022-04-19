package com.example.clinica_odontologica.service;

import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;
    private Domicilio domicilio;
    private PacienteDTO pacienteDTO;

    @BeforeEach
    public void prepararPaciente() {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Bv. San Juan");
        domicilio.setNumero("1489");
        domicilio.setLocalidad("Córdoba");
        domicilio.setProvincia("Córdoba");

        pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Alejandra");
        pacienteDTO.setApellido("Farías");
        pacienteDTO.setEmail("alejandra_farias@gmail.com");
        pacienteDTO.setDni(25987654);
        pacienteDTO.setFechaIngreso(new Date(122, 2, 1));
        pacienteDTO.setDomicilio(domicilio);
    }

    @Test
    public void testCrearPaciente() {
        pacienteService.crearPaciente(pacienteDTO);
        PacienteDTO paciente =  pacienteService.leerPaciente(1L);
        assertTrue(paciente != null);
    }

    @Test
    public void testLeerPaciente(){
        pacienteService.crearPaciente(pacienteDTO);
        PacienteDTO paciente = pacienteService.leerPaciente(1L);
        assertNotNull(paciente.getId() != null);
    }

    @Test
    public void testLeerTodos() {
        pacienteService.crearPaciente(pacienteDTO);
        assertTrue(pacienteService.leerTodos().size() != 0);
    }

    @Test
    public void testEliminarPaciente() throws NotFoundException {
        pacienteService.crearPaciente(pacienteDTO);
        PacienteDTO paciente =  pacienteService.leerPaciente(1L);
        assertTrue(paciente != null);
        pacienteService.eliminarPaciente(paciente.getId());
        assertTrue(pacienteService.leerPaciente(1L) == null );
    }

}

