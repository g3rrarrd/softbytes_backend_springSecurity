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
@Table(name = "ciudades")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class cities {
    
    @Id
    @Column(name = "idciudad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCity;

    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "iddepartamento", referencedColumnName = "iddepartamento")
    private departments departments;

    @JsonIgnore
    @OneToMany(mappedBy = "idCity", cascade = CascadeType.ALL)
    private List<address> addresses;
}
