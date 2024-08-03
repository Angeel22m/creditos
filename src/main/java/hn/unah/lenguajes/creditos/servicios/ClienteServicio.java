package hn.unah.lenguajes.creditos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.creditos.modelos.Cliente;
import hn.unah.lenguajes.creditos.modelos.Prestamo;
import hn.unah.lenguajes.creditos.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente crearCliente(Cliente nvCliente) {

        List<Prestamo> nvPrestamo = nvCliente.getPrestamo();
        if (nvPrestamo != null) {
            for (Prestamo prestamo : nvPrestamo) {
                prestamo.setCliente(nvCliente);
            }

        }
        return this.clienteRepositorio.save(nvCliente);

    }
}
