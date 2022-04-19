package com.example.clinica_odontologica.service;

import com.example.clinica_odontologica.exceptions.NotFoundException;
import com.example.clinica_odontologica.model.*;
import com.example.clinica_odontologica.repository.impl.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private Odontologo guardarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO) {
        return guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO leerOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public Set<OdontologoDTO> leerTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo : odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    @Override
    public void eliminarOdontologo(Long id) throws NotFoundException {
        if(leerOdontologo(id) == null) {
            throw new NotFoundException("El odontólogo con id: " + id + " no existe. No se puede eliminar.");
        } else {
            odontologoRepository.deleteById(id);
        }
    }

    @Override
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDTO) throws NotFoundException {
        if(leerOdontologo(odontologoDTO.getId()) == null) {
            throw new NotFoundException("El odontólogo con id: " + odontologoDTO.getId() + " no existe. No se puede modificar.");
        } else {
            return guardarOdontologo(odontologoDTO);
        }
    }
}
