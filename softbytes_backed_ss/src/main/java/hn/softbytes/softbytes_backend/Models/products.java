package hn.softbytes.softbytes_backend.Models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class products {
    
    @Id
    @Column(name = "idproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Column(name = "codigoserie")
    private String serialCode;

    @Column(name = "nombre")
    private String name;

    @Column(name = "preciounidad")
    private double unityPrice;

    @Column(name = "fechapublicacion")
    private LocalDate publicationDate;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "imagen")
    private String picture;

    @ManyToOne
    @JoinColumn(name = "idsubcategoria", referencedColumnName = "idsubcategoria")
    private subCategories idSubCategories;

    @Column(name = "reseñas")
    private String reviews;

    @JsonIgnore
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<orderDetail> orderDetails;

}
