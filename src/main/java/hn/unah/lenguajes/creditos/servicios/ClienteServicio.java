package hn.unah.lenguajes.creditos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.creditos.modelos.Cliente;
import hn.unah.lenguajes.creditos.modelos.Prestamo;
import hn.unah.lenguajes.creditos.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

   
    public Cliente crearCliente(Cliente nvCliente){

        Prestamo nvPrestamo =nvCliente.getPretamo();
        if(nvPrestamo!=null){
            nvPrestamo.setCliente(nvCliente);
        }
        return this.clienteRepositorio.save(nvCliente);



    }
}
