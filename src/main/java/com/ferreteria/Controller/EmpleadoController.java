package com.ferreteria.controller;

import com.ferreteria.domain.Empleado;
import com.ferreteria.domain.Puesto;
import com.ferreteria.domain.Sucursal;
import com.ferreteria.service.EmpleadoService;
import com.ferreteria.service.PuestoService;
import com.ferreteria.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    private final SucursalService sucursalService;
    private final PuestoService puestoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService, SucursalService sucursalService, PuestoService puestoService) {
        this.empleadoService = empleadoService;
        this.sucursalService = sucursalService;
        this.puestoService = puestoService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "empleados/empleados"; // Página principal con botones
    }

     @GetMapping("/insertar")
    public String mostrarFormularioInsertar(Model model) {
        List<Sucursal> sucursales = sucursalService.obtenerSucursales();
        List<Puesto> puestos = puestoService.obtenerPuestos();
        model.addAttribute("sucursales", sucursales);
        model.addAttribute("puestos", puestos);
        return "empleados/insertar"; // Página para insertar empleado
    }

    @PostMapping("/agregar")
    public String agregarEmpleado(
            @RequestParam String direccion,
            @RequestParam String email,
            @RequestParam Long idSucursal,
            @RequestParam Long idPuesto,
            @RequestParam String estado,
            Model model) {

        Empleado empleado = new Empleado(direccion, email, idSucursal, idPuesto, estado);
        String resultado = empleadoService.agregarEmpleado(empleado);
        model.addAttribute("resultado", resultado);
        return "empleados/resultado"; // Página de resultado
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "empleados/eliminar"; // Página para eliminar empleado
    }

    @PostMapping("/eliminar")
    public String eliminarEmpleado(@RequestParam Long id, Model model) {
        String resultado = empleadoService.eliminarEmpleado(id);
        model.addAttribute("resultado", resultado);
        return "empleados/resultado"; // Página de resultado
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar(Model model) {
        List<Sucursal> sucursales = sucursalService.obtenerSucursales(); // Obtener lista de sucursales
        List<Puesto> puestos = puestoService.obtenerPuestos(); // Obtener lista de puestos
        model.addAttribute("sucursales", sucursales);
        model.addAttribute("puestos", puestos);
        return "empleados/actualizar"; // Página para actualizar empleado
    }

    @PostMapping("/actualizar")
    public String actualizarEmpleado(
            @RequestParam Long id,
            @RequestParam String direccion,
            @RequestParam String email,
            @RequestParam Long idSucursal,
            @RequestParam Long idPuesto,
            @RequestParam String estado,
            Model model) {

        Empleado empleado = new Empleado(direccion, email, idSucursal, idPuesto, estado);
        empleado.setIdEmpleado(id);
        String resultado = empleadoService.actualizarEmpleado(empleado);
        model.addAttribute("resultado", resultado);
        return "empleados/resultado"; // Página de resultado
    }
}
