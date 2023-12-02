package hn.softbytes.softbytes_backend.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class users{
    
    public users(String name, String lastName, String password, String email, String username,List<authority> authorities) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.username = username;
    }

    @Id
    @Column(name = "idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "contrasenia")
    private String password;

    @Column(name = "telefono")
    private String telephone;

    @Column(name = "correo")
    private String email;

    @Column(name = "fechanacimiento")
    private LocalDate dateofBirth;

    @Column(name = "informacioncontacto")
    private String contactInformation;

    @Column(name = "preferenciaenvio")
    private String shippingPreference;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "idtipousuario", referencedColumnName = "idtipousuario")
    private userType usertype;

    @OneToMany(mappedBy = "idUsers", cascade = CascadeType.ALL)
    private List<address> addresses = new ArrayList<address>();

    @JsonIgnore
    @ManyToMany(mappedBy = "idUsers", cascade = CascadeType.ALL)
    private List<orders> iOrders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(name = "idusuario", referencedColumnName = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "idauthority", referencedColumnName = "id")
    )
    private List<authority> authorities;
}
