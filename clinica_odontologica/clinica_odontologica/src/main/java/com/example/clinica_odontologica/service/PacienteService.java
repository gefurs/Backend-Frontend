package com.example.clinica_odontologica.service;

import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.*;
import com.example.clinica_odontologica.repository.impl.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private Paciente guardarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente crearPaciente(PacienteDTO pacienteDTO) {
        return guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO leerPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> leerTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente : pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public void eliminarPaciente(Long id) throws NotFoundException {
        if(leerPaciente(id) == null) {
            throw new NotFoundException("El paciente con id: " + id + " no existe. No se puede eliminar.");
        } else {
            pacienteRepository.deleteById(id);
        }
    }

    @Override
    public Paciente modificarPaciente(PacienteDTO pacienteDTO) throws NotFoundException {
        if(leerPaciente(pacienteDTO.getId()) == null) {
            throw new NotFoundException("El paciente con id: " + pacienteDTO.getId() + " no existe. No se puede modificar.");
        } else {
            return guardarPaciente(pacienteDTO);
        }
    }
}
