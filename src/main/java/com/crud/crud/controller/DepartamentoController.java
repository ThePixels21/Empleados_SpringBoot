package com.crud.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.crud.entity.Departamento;
import com.crud.crud.service.DepartamentoServicio;

@Controller
public class DepartamentoController {
    
    @Autowired
    private DepartamentoServicio servicioDep;

    @GetMapping({"/departamentos"})
    public String listarDepartamento(Model modelo) {
        modelo.addAttribute("departamentos", servicioDep.listarTodosLosDepartamentos());
        return "departamentos/departamentos";
    }

    @GetMapping("/departamentos/nuevo")
    public String formularioRegistroDepartamento(Model modelo) {
        modelo.addAttribute("departamento", new Departamento());
        return "departamentos/crear_departamento";
    }

    @PostMapping("/departamentos")
    public String guardarDepartamento(@ModelAttribute("departamento") Departamento departamento) {
        servicioDep.guardarDepartamento(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/departamentos/eliminar/{codigo}")
    public String eliminarEmpleado(@PathVariable int codigo) {
        servicioDep.eliminarDepartamento(codigo);
        return "redirect:/departamentos";
    }

}
