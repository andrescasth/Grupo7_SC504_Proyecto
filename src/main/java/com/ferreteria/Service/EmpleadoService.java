package com.ferreteria.service;

import com.ferreteria.domain.Empleado;
import com.ferreteria.dao.EmpleadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    private final EmpleadoDao empleadoDao;

    @Autowired
    public EmpleadoService(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }

    public String agregarEmpleado(Empleado empleado) {
        return empleadoDao.agregarEmpleado(empleado);
    }

    public String eliminarEmpleado(Long id) {
        return empleadoDao.eliminarEmpleado(id);
    }

    public String actualizarEmpleado(Empleado empleado) {
        return empleadoDao.actualizarEmpleado(empleado);
    }
}
