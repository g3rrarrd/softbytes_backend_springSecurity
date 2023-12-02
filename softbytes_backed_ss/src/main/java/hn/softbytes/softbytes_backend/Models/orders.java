package hn.softbytes.softbytes_backend.Models;

import java.time.LocalDate;
import java.util.List;

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
@Table(name = "pedidos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class orders {

    @Id
    @Column(name = "idpedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrders;

    @Column(name = "fechapedido")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "idestadopedido", referencedColumnName = "idestadopedido")
    private orderStatus idOrderStatus;

    @Column(name = "monto")
    private double amount;

    @OneToOne(mappedBy = "idOrder", cascade = CascadeType.ALL)
    private sales sales;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "orders_users",
        joinColumns = @JoinColumn(name="idpedido", referencedColumnName = "idpedido"),
        inverseJoinColumns = @JoinColumn(name="idusuario", referencedColumnName = "idusuario")
    )
    private List<users> idUsers;
}
