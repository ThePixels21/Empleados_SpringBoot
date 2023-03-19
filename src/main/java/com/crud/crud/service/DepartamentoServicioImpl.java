package com.crud.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crud.entity.Departamento;
import com.crud.crud.repositorie.DepartamentoRepositorio;

@Service
public class DepartamentoServicioImpl implements DepartamentoServicio {

    @Autowired
    private DepartamentoRepositorio repositorio;

    @Override
    public List<Departamento> listarTodosLosDepartamentos() {
        return repositorio.findAll();
    }

    @Override
    public Departamento guardarDepartamento(Departamento departamento) {
        return repositorio.save(departamento);
    }

    @Override
    public Departamento obtenerDepartamentoPorId(int id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Departamento actualizarDepartamento(Departamento departamento) {
        return repositorio.save(departamento);
    }

    @Override
    public void eliminarDepartamento(int id) {
        repositorio.deleteById(id);
    }
    
}
