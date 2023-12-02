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
@Table(name = "departamentos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class departments {
    
    @Id
    @Column(name = "iddepartamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartment;

    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    private countries idCountry;

    @JsonIgnore
    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private List<cities> cities;
}
