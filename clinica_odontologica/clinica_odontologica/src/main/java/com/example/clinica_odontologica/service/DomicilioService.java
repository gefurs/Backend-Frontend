package com.example.clinica_odontologica.service;

import com.example.clinica_odontologica.model.Domicilio;
import com.example.clinica_odontologica.repository.impl.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

    @Autowired
    DomicilioRepository domicilioRepository;

    public DomicilioService() {
    }

    public Domicilio guardar(Domicilio d){
        return domicilioRepository.save(d);
    }

    public Optional<Domicilio> buscar(Long id){
        return domicilioRepository.findById(id);
    }

    public List<Domicilio> buscarTodos(){
        return domicilioRepository.findAll();
    }

    public void eliminar(Long id){
        domicilioRepository.deleteById(id);
    }

    public Domicilio actualizar(Domicilio d) {
        return domicilioRepository.save(d);
    }
}
