package hn.softbytes.softbytes_backend.Models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ventas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class sales {
    
    @Id
    @Column(name = "idventa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSales;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "idpedido", referencedColumnName = "idPedido")
    private orders idOrder;

    @Column(name = "fecha")
    private LocalDate date;

    @Column(name = "subtotal")
    private double subTotal;

    @Column(name = "ISV")
    private double isv;

    @Column(name = "total")
    private double total;

}
