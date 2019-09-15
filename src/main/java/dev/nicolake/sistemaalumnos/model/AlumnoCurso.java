package dev.nicolake.sistemaalumnos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AlumnoCurso implements Serializable {

    @Column(name = "idalumno")
    private int alumno;

    @Column(name = "idcurso")
    private int curso;

    public AlumnoCurso(int alumno, int curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    public AlumnoCurso() {
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
}
