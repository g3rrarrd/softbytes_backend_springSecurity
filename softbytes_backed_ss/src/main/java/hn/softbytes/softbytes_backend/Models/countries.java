package hn.softbytes.softbytes_backend.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paises")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class countries {
    
    @Id
    @Column(name = "idpais")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCountry;

    @Column(name = "nombre")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "idCountry", cascade = CascadeType.ALL)
    private List<departments> departments;
}
