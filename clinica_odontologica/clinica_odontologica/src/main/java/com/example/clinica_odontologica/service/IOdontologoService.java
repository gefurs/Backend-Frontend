package com.example.clinica_odontologica.service;

import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.Odontologo;
import com.example.clinica_odontologica.model.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO);

    public OdontologoDTO leerOdontologo(Long id);

    Set<OdontologoDTO> leerTodos();

    public void eliminarOdontologo(Long id) throws NotFoundException;

    public Odontologo modificarOdontologo(OdontologoDTO odontologoDTO) throws NotFoundException;

}
