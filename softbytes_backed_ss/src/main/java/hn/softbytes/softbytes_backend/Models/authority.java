package hn.softbytes.softbytes_backend.Models;

import hn.softbytes.softbytes_backend.Utils.authorityRoles;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "autorities")
public class authority {

    public authority (authorityRoles authorityRoles){
        this.name = authorityRoles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private authorityRoles name;
    
}
