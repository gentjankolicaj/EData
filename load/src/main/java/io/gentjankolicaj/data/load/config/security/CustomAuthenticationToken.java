package io.gentjankolicaj.data.load.config.security;

import io.gentjankolicaj.data.load.common.domain.security.CustomUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String email;
    private String token;


    public CustomAuthenticationToken(String principal,String credentials,String email) {
        super(principal, credentials);
        this.email=email;
    }

    public CustomAuthenticationToken(String principal,String credentials,String email,String token) {
        super(principal, credentials);
        this.email=email;
        this.token=token;
    }

    public CustomAuthenticationToken(CustomUserDetails principal, String credentials,Collection<? extends GrantedAuthority> authorities,String email) {
        super(principal, credentials, authorities);
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
