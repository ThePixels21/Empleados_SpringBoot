package com.crud.crud.service;

import java.util.List;

import com.crud.crud.entity.Departamento;

public interface DepartamentoServicio {

    public List<Departamento> listarTodosLosDepartamentos();

    public Departamento guardarDepartamento(Departamento departamento);

    public Departamento obtenerDepartamentoPorId(long id);

    public Departamento actualizarDepartamento(Departamento departamento);

    public void eliminarDepartamento(long id);
}
