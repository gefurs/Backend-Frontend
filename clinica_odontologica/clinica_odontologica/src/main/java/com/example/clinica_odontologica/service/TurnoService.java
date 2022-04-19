package com.example.clinica_odontologica.service;

import com.example.clinica_odontologica.exceptions.BadRequestException;
import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.*;
import com.example.clinica_odontologica.repository.impl.OdontologoRepository;
import com.example.clinica_odontologica.repository.impl.PacienteRepository;
import com.example.clinica_odontologica.repository.impl.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private Turno guardarTurno(TurnoDTO turnoDTO) {
        Paciente paciente = pacienteRepository.findById(turnoDTO.getPaciente().getId()).get();
        Odontologo odontologo = odontologoRepository.findById(turnoDTO.getOdontologo().getId()).get();
        turnoDTO.setPaciente(paciente);
        turnoDTO.setOdontologo(odontologo);
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        return turnoRepository.save(turno);
    }

    @Override
    public Turno crearTurno(TurnoDTO turnoDTO) throws BadRequestException {
        Paciente paciente = turnoDTO.getPaciente();
        Optional <Paciente> paciente1 = pacienteRepository.findById(paciente.getId());
        Odontologo odontologo = turnoDTO.getOdontologo();
        Optional<Odontologo> odontologo1 = odontologoRepository.findById(odontologo.getId());

        if(!paciente1.isPresent() || !odontologo1.isPresent()){
            throw new BadRequestException("El paciente o el odontólogo no existen. No se puede crear el turno.");
        }
        return guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO leerTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public Set<TurnoDTO> leerTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for (Turno turno : turnos) {
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }

    @Override
    public void eliminarTurno(Long id) throws NotFoundException {
        if(leerTurno(id) == null) {
            throw new NotFoundException("El turno con id: " + id + " no existe. No se puede eliminar.");
        } else {
            turnoRepository.deleteById(id);
        }
    }

    @Override
    public Turno modificarTurno(TurnoDTO turnoDTO) throws NotFoundException {
        if(leerTurno(turnoDTO.getId()) == null) {
            throw new NotFoundException("El turno con id: " + turnoDTO.getId() + " no existe. No se puede modificar.");
        } else {
            return guardarTurno(turnoDTO);
        }
    }
}
