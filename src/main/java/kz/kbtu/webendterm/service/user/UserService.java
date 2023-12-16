package kz.kbtu.webendterm.service.user;

import kz.kbtu.webendterm.dto.login.LoginRequestDTO;
import kz.kbtu.webendterm.dto.login.LoginResponseDTO;
import kz.kbtu.webendterm.dto.register.RegisterRequestDTO;
import kz.kbtu.webendterm.entity.User;

public interface UserService {

  User getUser(Long id);

  void registerUser(RegisterRequestDTO user);

  LoginResponseDTO login(LoginRequestDTO user);

}
