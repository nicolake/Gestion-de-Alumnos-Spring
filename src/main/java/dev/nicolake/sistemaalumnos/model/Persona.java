package dev.nicolake.sistemaalumnos.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer identificador;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private long documento;

    @Column
    private LocalTime fechanac;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipodoc;

    public Persona(int identificador, String nombre, String apellido, long documento, LocalTime fechanac, TipoDocumento tipodoc) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechanac = fechanac;
        this.tipodoc = tipodoc;
    }

    public Persona(){}

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public LocalTime getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalTime fechanac) {
        this.fechanac = fechanac;
    }

    public TipoDocumento getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TipoDocumento tipodoc) {
        this.tipodoc = tipodoc;
    }
}
