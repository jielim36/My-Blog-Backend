package com.myblog.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserLogin implements UserDetails {

    private final User user;

    public UserLogin(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Map your user types to roles here
        if (Integer.parseInt(user.getUserType()) == 0) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (Integer.parseInt(user.getUserType()) == 1) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // Return the actual password
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // Return the actual username (e.g., email)
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement logic to check if the account is non-expired
        return true; // Example: always consider the account as non-expired
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement logic to check if the account is non-locked
        return true; // Example: always consider the account as non-locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement logic to check if credentials are non-expired
        return true; // Example: always consider credentials as non-expired
    }

    @Override
    public boolean isEnabled() {
        // Implement logic to check if the user is enabled
        return Integer.parseInt(user.getStatus()) != 1;
    }
}
