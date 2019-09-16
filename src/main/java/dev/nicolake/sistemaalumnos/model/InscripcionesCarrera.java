package dev.nicolake.sistemaalumnos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "inscripciones_carrera")
public class InscripcionesCarrera {
    @EmbeddedId
    private AlumnoCarrera alumnocarrera;

    @ManyToOne
    @JoinColumn(name = "idalumno", nullable = false, insertable = false, updatable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idcarrera", nullable = false, insertable = false, updatable = false)
    private Carrera carrera;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechainscripcion;

    public InscripcionesCarrera() {
    }

    public AlumnoCarrera getAlumnocarrera() {
        return alumnocarrera;
    }

    public void setAlumnocarrera(AlumnoCarrera alumnocarrera) {
        this.alumnocarrera = alumnocarrera;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public LocalDate getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(LocalDate fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }
}
