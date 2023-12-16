package kz.kbtu.webendterm.controller;

import kz.kbtu.webendterm.dto.ApiResponse;
import kz.kbtu.webendterm.dto.login.LoginRequestDTO;
import kz.kbtu.webendterm.dto.login.LoginResponseDTO;
import kz.kbtu.webendterm.dto.register.RegisterRequestDTO;
import kz.kbtu.webendterm.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ApiResponse<Void> register(@RequestBody RegisterRequestDTO user) {
    try {
      userService.registerUser(user);
      return new ApiResponse<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/login")
  public ApiResponse<LoginResponseDTO> login(@RequestBody LoginRequestDTO user) {
    try {
      LoginResponseDTO response = userService.login(user);
      return new ApiResponse<>(HttpStatus.OK, response);
    } catch (Exception e) {
      return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
