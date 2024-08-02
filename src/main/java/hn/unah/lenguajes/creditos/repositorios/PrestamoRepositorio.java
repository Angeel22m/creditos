package hn.unah.lenguajes.creditos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes.creditos.modelos.Prestamo;

public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long> {
    
}
