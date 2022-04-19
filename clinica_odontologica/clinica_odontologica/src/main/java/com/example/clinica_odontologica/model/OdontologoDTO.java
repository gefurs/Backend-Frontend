package com.example.clinica_odontologica.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;
    private Set<Turno> turnos = new HashSet<>();
}
