package dev.nicolake.sistemaalumnos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "inscripciones_curso")
public class InscripcionesCurso {
    @EmbeddedId
    private AlumnoCurso alumnocurso;

    @ManyToOne
    @JoinColumn(name = "idalumno", insertable = false, updatable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idcurso", insertable = false, updatable = false)
    private Curso curso;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechainscripcion;

    @Column
    private double nota;

    public InscripcionesCurso() {
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(LocalDate fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
