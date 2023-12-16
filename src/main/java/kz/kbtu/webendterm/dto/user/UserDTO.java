package kz.kbtu.webendterm.dto.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements UserDetails {

  private String username;

  private String password;

  private final Set<Role> authorities = new HashSet<>();

  public UserDTO setUsername(String username) {
    this.username = username;
    return this;
  }

  public UserDTO setPassword(String password) {
    this.password = password;
    return this;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return Boolean.TRUE;
  }

  @Override
  public boolean isAccountNonLocked() {
    return Boolean.TRUE;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return Boolean.TRUE;
  }

  @Override
  public boolean isEnabled() {
    return Boolean.TRUE;
  }
}
