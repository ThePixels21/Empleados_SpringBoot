package com.crud.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crud.entity.Empleado;
import com.crud.crud.repositorie.EmpleadoRepositorio;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {
    
    @Autowired
    private EmpleadoRepositorio repositorio;

    @Override
    public List<Empleado> listarTodosLosEmpleados() {
        return repositorio.findAll(); 
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return repositorio.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(int id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        return repositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(int id) {
        repositorio.deleteById(id);
    }
}
