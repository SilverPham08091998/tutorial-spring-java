package com.example.springjava.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal implements UserDetails {
    private static final long serialVersionUID = -5162456130461860047L;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String userId;
    private String role;
    private String idCard;
    private String phoneNumber;
    private String email;

    public static UserPrincipal create(UserDetail user) {
        if (user == null)
            return new UserPrincipal();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new UserPrincipal(
                user.getUsername(),
                user.getPassword(),
                authorities,
                user.getUserId(),
                user.getRole(),
                user.getIdCard(),
                user.getPhoneNumber(),
                user.getEmail()

        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
