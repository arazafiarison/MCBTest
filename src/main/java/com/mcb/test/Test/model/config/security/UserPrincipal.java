package com.mcb.test.Test.model.config.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mcb.test.Test.model.collection.authentication.Login;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 4015109283869723153L;
    private String id;
    private String userId;
    private String username;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String id, String userId, String login, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userId = userId;
        this.username = login;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Login login) {
        List<GrantedAuthority> authorities = login.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name().toString())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                login.getId(),
                login.getUserId(),
                login.getLogin(),
                login.getEmail(),
                login.getPassword(),
                authorities
        );
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    // Return userId instead of loginId for hashCode
    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
