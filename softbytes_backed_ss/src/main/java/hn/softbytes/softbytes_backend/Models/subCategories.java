package hn.softbytes.softbytes_backend.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subcategorias")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class subCategories {
    
    @Id
    @Column(name = "idsubcategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubCategory;

    @ManyToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    private categories categories;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "imagen")
    private String picture;

    @JsonIgnore
    @OneToMany(mappedBy = "idSubCategories", cascade = CascadeType.ALL)
    private List<products> products;
}
