package com.example.clinica_odontologica.model;

import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    private Date fechaIngreso;
    private Domicilio domicilio;
    private Set<Turno> turnos = new HashSet<>();
}
