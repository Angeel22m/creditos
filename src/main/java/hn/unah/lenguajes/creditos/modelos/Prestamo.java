package hn.unah.lenguajes.creditos.modelos;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prestamos")
@Data
public class Prestamo {

    @Id

    private long codigoPrestamo;

    private LocalTime fechaApertura;
    private double monto;
    private double cuota;
    private int plazo;
    private double interes;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente cliente;
    
}
