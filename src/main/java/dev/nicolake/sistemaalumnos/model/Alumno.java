package dev.nicolake.sistemaalumnos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "idpersona")
public class Alumno extends Persona{

    @Column(nullable=false)
    private int legajo;

    public Alumno(TipoDocumento tipoDocumento, int numeroDocumento, String nombre, String apellido, LocalDate fechaNacimiento, int legajo){
        super(nombre, apellido, numeroDocumento, fechaNacimiento, tipoDocumento);

        this.legajo = legajo;
    }

    public Alumno(){}
}