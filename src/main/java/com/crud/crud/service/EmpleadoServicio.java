package com.crud.crud.service;

import java.util.List;

import com.crud.crud.entity.Empleado;

public interface EmpleadoServicio {
    
    public List<Empleado> listarTodosLosEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado obtenerEmpleadoPorId(long id);

    public Empleado actualizarEmpleado(Empleado empleado);

    public void eliminarEmpleado(long id);

}
