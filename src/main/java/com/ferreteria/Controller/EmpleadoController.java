package com.ferreteria.controller;

import com.ferreteria.domain.Empleado;
import com.ferreteria.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/agregar")
    public String agregarEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.agregarEmpleado(empleado);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable int id) {
        return empleadoService.eliminarEmpleado(id);
    }
}
