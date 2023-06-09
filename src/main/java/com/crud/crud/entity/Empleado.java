package com.crud.crud.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Embeddable
@Table(name = "empleado")
public class Empleado implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;

    @NotEmpty(message = "No puede estar vacío")
    @Column(name = "nif", nullable = false, length = 9)
    private String nif;

    @NotEmpty(message = "No puede estar vacío")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotEmpty(message = "No puede estar vacío")
    @Column(name = "apellido1", nullable = false, length = 100)
    private String apellido1;

    @NotEmpty(message = "No puede estar vacío")
    @Column(name = "apellido2", nullable = false, length = 100)
    private String apellido2;

    @ManyToOne
    @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo", nullable = false)
    private Departamento departamento;

    public Empleado() {
        this.departamento = new Departamento();
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
