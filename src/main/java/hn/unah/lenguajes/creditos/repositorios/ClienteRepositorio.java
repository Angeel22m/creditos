package hn.unah.lenguajes.creditos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes.creditos.modelos.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

    
} 