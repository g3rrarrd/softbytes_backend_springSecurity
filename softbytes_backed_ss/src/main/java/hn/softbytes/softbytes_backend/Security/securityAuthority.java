package hn.softbytes.softbytes_backend.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import hn.softbytes.softbytes_backend.Models.authority;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class securityAuthority implements GrantedAuthority{

    @Autowired
    private authority authority;

    @Override
    public String getAuthority() {
        
        return authority.getName().toString();

    }
    
}
