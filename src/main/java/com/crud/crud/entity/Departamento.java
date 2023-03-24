package com.crud.crud.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;

    @NotEmpty(message = "No puede estar vacío")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Min(value = 0, message = "Valor mínimo 0")
    @Column(name = "presupuesto", nullable = false)
    private double presupuesto;

    @Min(value = 0, message = "Valor mínimo 0")
    @Column(name = "gastos", nullable = false)
    private double gastos;

    @OneToMany(mappedBy="departamento")
    private List<Empleado> empleados;


    public Departamento() {}

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

}
