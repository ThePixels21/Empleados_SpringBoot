package com.crud.crud.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.crud.entity.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer>{
    
}
