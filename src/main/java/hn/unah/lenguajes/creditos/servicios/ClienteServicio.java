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
        if (!this.clienteRepositorio.existsById(nvCliente.getDni())) {
            List<Prestamo> nvPrestamo = nvCliente.getPrestamo();
            if (nvPrestamo != null) {
                for (Prestamo prestamo : nvPrestamo) {
                    prestamo.setCliente(nvCliente);
                    prestamo.setCuota(this.obtenerCuota(prestamo.getMonto(),prestamo.getInteres()));
                }

            }
            return this.clienteRepositorio.save(nvCliente);
        }

        return null;
    }

    public List<Cliente> obtenerClientes() {

        return this.clienteRepositorio.findAll();
    }

    public Cliente buscarPorDni(String dni) {
        return this.clienteRepositorio.findById(dni).get();
    }

    public double obtenerCuota(double monto, double interes){
        double A = Math.pow(monto*interes*(1+interes), 60);
        double B = Math.pow((1+interes), 60)-1;

        return A/B;

    }
}
