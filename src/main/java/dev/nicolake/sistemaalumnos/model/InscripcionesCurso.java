package dev.nicolake.sistemaalumnos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "inscrpciones_curso")
public class InscripcionesCurso {

    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechainscripcion;

    @Column
    private double nota;
}
