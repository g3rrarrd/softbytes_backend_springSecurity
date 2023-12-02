package hn.softbytes.softbytes_backend.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direccion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class address {
    
    @Id
    @Column(name = "iddireccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAddres;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private users idUsers;

    @Column(name = "direccion")
    private String address;

    @ManyToOne
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    private cities idCity;

    @Column(name = "codigopostal")
    private String zipCode;

}
