package dev.nicolake.sistemaalumnos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AlumnoCarrera implements Serializable {
    @Column(name = "idalumno")
    private int alumno;

    @Column(name = "idcarrera")
    private int carrera;

    public AlumnoCarrera(int alumno, int carrera) {
        this.alumno = alumno;
        this.carrera = carrera;
    }

    public AlumnoCarrera() {
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }
}
