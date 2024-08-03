package hn.unah.lenguajes.creditos.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.creditos.modelos.Prestamo;
import hn.unah.lenguajes.creditos.servicios.PrestamoServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoServicio prestamoServicio;

    @GetMapping("/todos")
    public List<Prestamo> obtenerTodos() {
        return this.prestamoServicio.obtenerPrestamos();
    }

    @PostMapping("/nuevo/{dni}")
    public Prestamo crearPrestamo(@PathVariable(name = "dni") String dni
        ,@RequestBody Prestamo nvPrestamo) {
        
        
        return this.crearPrestamo(dni, nvPrestamo);
    }
    
    
    
}
