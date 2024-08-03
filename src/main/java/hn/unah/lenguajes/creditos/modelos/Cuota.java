package hn.unah.lenguajes.creditos.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cuota")
@Data
public class Cuota {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "codigocuota")
   private long codigoCuota;

   private int mes;
   private double interes;
   private double capital;
   private double saldo;

   @ManyToOne
   @JoinColumn(name = "codigoprestamo", referencedColumnName = "codigoprestamo")
   private Prestamo prestamo;

}
