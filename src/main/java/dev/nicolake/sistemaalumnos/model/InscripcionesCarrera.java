package dev.nicolake.sistemaalumnos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "inscripciones_carrera")
public class InscripcionesCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;

    @ManyToOne
    @JoinColumn(name = "idalumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idcarrera", nullable = false)
    private Carrera carrera;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechainscripcion;
}
