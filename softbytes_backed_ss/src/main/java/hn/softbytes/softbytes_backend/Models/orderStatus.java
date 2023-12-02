package hn.softbytes.softbytes_backend.Models;


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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estadopedido")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class orderStatus {

    @Id
    @Column(name = "idestadopedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrderStatus;

    @Column(name = "descripcion")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "idOrderStatus", cascade = CascadeType.ALL)
    private List<orders> orders;
}
