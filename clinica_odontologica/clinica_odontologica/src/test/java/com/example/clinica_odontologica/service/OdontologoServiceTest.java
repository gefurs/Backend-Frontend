package com.example.clinica_odontologica.service;

import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.OdontologoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;
    private OdontologoDTO odontologoDTO;

    @BeforeEach
    public void prepararOdontologo() {
        odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Pedro");
        odontologoDTO.setApellido("Ramirez");
        odontologoDTO.setMatricula(123456);
    }

    @Test
    public void testCrearOdontologo() {
        odontologoService.crearOdontologo(odontologoDTO);
        OdontologoDTO odontologo = odontologoService.leerOdontologo(1L);
        assertTrue(odontologo.getMatricula() != null);
    }

    @Test
    public void testLeerOdontologo(){
        odontologoService.crearOdontologo(odontologoDTO);
        OdontologoDTO odontologo = odontologoService.leerOdontologo(1L);
        assertNotNull(odontologo.getId() != null);
    }

    @Test
    public void testLeerTodos() {
        odontologoService.crearOdontologo(odontologoDTO);
        assertTrue(odontologoService.leerTodos().size() != 0);
    }

    @Test
    public void testEliminarOdontologo() throws NotFoundException {
        odontologoService.crearOdontologo(odontologoDTO);
        OdontologoDTO odontologo =  odontologoService.leerOdontologo(1L);
        assertTrue(odontologo != null);
        odontologoService.eliminarOdontologo(odontologo.getId());
        assertTrue(odontologoService.leerOdontologo(1L) == null );
    }

}