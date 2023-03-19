package com.crud.crud.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.crud.entity.Departamento;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {
    
}
