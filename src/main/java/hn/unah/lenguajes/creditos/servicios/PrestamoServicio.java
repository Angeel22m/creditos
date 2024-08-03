package hn.unah.lenguajes.creditos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.creditos.modelos.Prestamo;
import hn.unah.lenguajes.creditos.repositorios.ClienteRepositorio;
import hn.unah.lenguajes.creditos.repositorios.PrestamoRepositorio;

@Service
public class PrestamoServicio {

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Prestamo crearPrestamo(String dni, Prestamo nvPrestamo) {
        if (this.clienteRepositorio.existsById(dni)) {
            nvPrestamo.setCliente(this.clienteRepositorio.findById(dni).get());
            nvPrestamo.setCuota(this.obtenerCuota(nvPrestamo.getMonto(), nvPrestamo.getInteres()));
            return this.prestamoRepositorio.save(nvPrestamo);

        }
        return null;

    }

    public List<Prestamo> obtenerPrestamos() {

        return this.prestamoRepositorio.findAll();
    }

    public double obtenerCuota(double monto, double interes) {
        double A = Math.pow(monto * interes * (1 + interes), 60);
        double B = Math.pow((1 + interes), 60) - 1;

        return A / B;

    }
}
