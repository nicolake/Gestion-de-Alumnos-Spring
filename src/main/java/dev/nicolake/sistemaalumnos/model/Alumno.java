package dev.nicolake.sistemaalumnos.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "idpersona")
public class Alumno extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;

    @Column(nullable = false)
    private int legajo;

    public Alumno(TipoDocumento tipoDocumento, int numeroDocumento, String nombre, String apellido, LocalDate fechaNacimiento, int legajo) {
        super(nombre, apellido, numeroDocumento, fechaNacimiento, tipoDocumento);

        this.legajo = legajo;
    }

    public Alumno() {
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    @Override
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }
}
