package hn.unah.lenguajes.creditos.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.creditos.modelos.Cliente;
import hn.unah.lenguajes.creditos.servicios.ClienteServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteServicio clienteServicio;

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente nvCliente) {

        return this.clienteServicio.crearCliente(nvCliente);
    }

    @GetMapping("/todos")
    public List<Cliente> obtenerClientes() {
        return this.clienteServicio.obtenerClientes();
    }

}
