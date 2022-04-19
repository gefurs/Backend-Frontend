package com.example.clinica_odontologica.service;

import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.Paciente;
import com.example.clinica_odontologica.model.PacienteDTO;

import java.util.Set;

public interface IPacienteService {

    public Paciente crearPaciente(PacienteDTO pacienteDTO);

    public PacienteDTO leerPaciente(Long id);

    Set<PacienteDTO> leerTodos();

    public void eliminarPaciente(Long id) throws NotFoundException;

    public Paciente modificarPaciente(PacienteDTO pacienteDTO) throws NotFoundException;

}
