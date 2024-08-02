package hn.unah.lenguajes.creditos.modelos;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prestamos")
@Data
public class Prestamos {

    @Id

    private long codigoPrestamo;

    private LocalTime fechaApertura;
    
}
