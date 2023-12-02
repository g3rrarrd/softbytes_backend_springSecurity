package hn.softbytes.softbytes_backend.Models;

import java.util.List;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detallepedido")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class orderDetail {

    @Id
    @Column(name = "iddetallepedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrderDetail;    

    @ManyToOne
    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    private orders idOrders;

    @Column(name = "preciounidad")
    private double unityPrice;

    @Column(name = "cantidad")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    private products products;
}
