package hn.softbytes.softbytes_backend.Models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class newUserJson {
    
    private String name;

    private String lastName;

    private String password;

    private String telephone;

    private String email;

    private LocalDate dateOfBirth;

    private String contactInformation;

    private String shippingPreference;

    private int city;

    private String address;

    private String zipCode;

}
