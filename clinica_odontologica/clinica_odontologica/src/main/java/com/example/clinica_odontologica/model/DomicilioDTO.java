package com.example.clinica_odontologica.model;

import lombok.*;

@Getter
@Setter
public class DomicilioDTO {
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
