package kz.kbtu.webendterm.dto.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  USER;

  @Override
  public String getAuthority() {
    return name();
  }
}
