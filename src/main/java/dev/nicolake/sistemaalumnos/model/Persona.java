package dev.nicolake.sistemaalumnos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false)
    private String apellido;

    @Column(nullable=false)
    private long documento;

    @Column (nullable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechanac;

    @Column (nullable=false)
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipodoc;

    public Persona(String nombre, String apellido, long documento, LocalDate fechanac, TipoDocumento tipodoc) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechanac = fechanac;
        this.tipodoc = tipodoc;
    }

    public Persona(){}

    public Integer getIdentificador() {
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

    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }

    public TipoDocumento getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TipoDocumento tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String fechaNacimientoFormat(){
        return fechanac.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }
}
