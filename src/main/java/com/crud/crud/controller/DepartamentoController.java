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

    @GetMapping("/departamentos/editar/{codigo}")
    public String mostrarFormActualizar(@PathVariable int codigo, Model modelo) {
        modelo.addAttribute("departamento", servicioDep.obtenerDepartamentoPorId(codigo));
        modelo.addAttribute("departamentos", servicioDep.listarTodosLosDepartamentos());
        return "departamentos/editar_departamento";
    }

    @PostMapping("/departamentos/{codigo}")
    public String actualizarDepartamento(@PathVariable int codigo, @ModelAttribute("departamento") Departamento departamento, Model modelo) {
        Departamento dep = servicioDep.obtenerDepartamentoPorId(codigo);
        dep.setCodigo(codigo);
        dep.setNombre(departamento.getNombre());
        dep.setPresupuesto(departamento.getPresupuesto());
        dep.setGastos(departamento.getGastos());

        servicioDep.actualizarDepartamento(dep);

        return "redirect:/departamentos";
    }

    @GetMapping("/departamentos/eliminar/{codigo}")
    public String eliminarDepartamento(@PathVariable int codigo) {
        servicioDep.eliminarDepartamento(codigo);
        return "redirect:/departamentos";
    }

}
