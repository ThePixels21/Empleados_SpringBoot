package com.crud.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.crud.entity.Empleado;
import com.crud.crud.service.DepartamentoServicio;
import com.crud.crud.service.EmpleadoServicio;

import jakarta.validation.Valid;

@Controller
public class EmpleadoController {
    
    @Autowired
    private EmpleadoServicio servicioEmp;

    @Autowired
    private DepartamentoServicio servicioDep;

    @GetMapping({"/empleados", "/", ""})
    public String listarEmpleados(Model modelo) {
        modelo.addAttribute("empleados", servicioEmp.listarTodosLosEmpleados());
        return "empleados/empleados";
    }

    @GetMapping("/empleados/nuevo")
    public String formularioRegistroEmpleado(Model modelo) {
        modelo.addAttribute("empleado", new Empleado());
        modelo.addAttribute("departamentos", servicioDep.listarTodosLosDepartamentos());
        return "empleados/crear_empleado";
    }

    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute("empleado") @Valid Empleado empleado, BindingResult resultado, Model modelo) {
        if(resultado.hasErrors()) {
            modelo.addAttribute("departamentos", servicioDep.listarTodosLosDepartamentos());
            return "empleados/crear_empleado";
        }
        servicioEmp.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{codigo}")
    public String mostrarFormActualizar(@PathVariable int codigo, Model modelo) {
        modelo.addAttribute("empleado", servicioEmp.obtenerEmpleadoPorId(codigo));
        modelo.addAttribute("departamentos", servicioDep.listarTodosLosDepartamentos());
        return "empleados/editar_empleado";
    }

    @PostMapping("/empleados/{codigo}")
    public String actualizarEmpleado(@PathVariable int codigo, @ModelAttribute("empleado") @Valid Empleado empleado, BindingResult resultado, Model modelo) {
        if(resultado.hasErrors()) {
            modelo.addAttribute("empleado", servicioEmp.obtenerEmpleadoPorId(codigo));
            modelo.addAttribute("departamentos", servicioDep.listarTodosLosDepartamentos());
            return "empleados/editar_empleado";
        }
        Empleado emp = servicioEmp.obtenerEmpleadoPorId(codigo);
        emp.setCodigo(codigo);
        emp.setNombre(empleado.getNombre());
        emp.setApellido1(empleado.getApellido1());
        emp.setApellido2(empleado.getApellido2());
        emp.setNif(empleado.getNif());
        emp.setDepartamento(empleado.getDepartamento());

        servicioEmp.actualizarEmpleado(emp);

        return "redirect:/empleados";
    }

    @GetMapping("/empleados/eliminar/{codigo}")
    public String eliminarEmpleado(@PathVariable int codigo) {
        servicioEmp.eliminarEmpleado(codigo);
        return "redirect:/empleados";
    }

}
