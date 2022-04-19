package com.example.clinica_odontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class TurnoDTO {
    private Long id;
    private Date fecha;
    private Time hora;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Paciente paciente;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Odontologo odontologo;
}
