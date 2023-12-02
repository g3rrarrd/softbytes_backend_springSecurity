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
@Table(name = "tipousuario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class userType{

    @Id
    @Column(name = "idtipousuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserType;

    @Column(name = "tipousuario")
    private String userType;

    @JsonIgnore
    @OneToMany(mappedBy = "usertype", cascade = CascadeType.ALL)
    private List<users> users; 

}
