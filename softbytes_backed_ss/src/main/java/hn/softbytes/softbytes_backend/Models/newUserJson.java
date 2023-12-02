package hn.softbytes.softbytes_backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class newUserJson {
    
    private users user;

    private String city;

    private String address;

    private String zipCode;

}
