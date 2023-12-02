package hn.softbytes.softbytes_backend.Security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import hn.softbytes.softbytes_backend.Models.users;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class securityUser implements UserDetails{

    @Autowired
    private users UserEntity;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return UserEntity.getAuthorities().stream().map(securityAuthority::new).toList();

    }

    @Override
    public String getPassword() {
        
        return UserEntity.getPassword();

    }

    @Override
    public String getUsername() {
        
        return UserEntity.getUsername();

    }

    @Override
    public boolean isAccountNonExpired() {
        
        return true;

    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;

    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;

    }

    @Override
    public boolean isEnabled() {
        
        return true;

    }
    


}
