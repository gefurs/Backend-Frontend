package com.example.clinica_odontologica.service;

import com.example.clinica_odontologica.exceptions.BadRequestException;
import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.Turno;
import com.example.clinica_odontologica.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {

    public Turno crearTurno(TurnoDTO turnoDTO) throws BadRequestException;

    public TurnoDTO leerTurno(Long id);

    Set<TurnoDTO> leerTodos();

    public void eliminarTurno(Long id) throws NotFoundException;

    public Turno modificarTurno(TurnoDTO turnoDTO) throws NotFoundException;

}
