package kz.kbtu.webendterm.service.user;

import kz.kbtu.webendterm.dto.login.LoginRequestDTO;
import kz.kbtu.webendterm.dto.login.LoginResponseDTO;
import kz.kbtu.webendterm.dto.register.RegisterRequestDTO;
import kz.kbtu.webendterm.dto.user.UserDTO;
import kz.kbtu.webendterm.entity.User;
import kz.kbtu.webendterm.repository.UserRepository;
import kz.kbtu.webendterm.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final JwtUtil jwtUtil;

  public UserServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
    this.userRepository = userRepository;
    this.jwtUtil = jwtUtil;
  }

  @Override
  @Transactional(readOnly = true)
  public User getUser(Long id) {
    return userRepository.findById(id).orElseThrow();
  }

  @Override
  @Transactional
  public void registerUser(RegisterRequestDTO user) {
    userRepository.save(
        new User()
            .setLogin(user.getName())
            .setPassword(user.getPassword())
            .setPhoneNumber(user.getPhoneNumber())
    );
  }

  @Override
  @Transactional
  public LoginResponseDTO login(LoginRequestDTO userRequest) {
    User user = userRepository.findByPhoneNumber(userRequest.getPhoneNumber()).orElseThrow();
    LoginResponseDTO response = new LoginResponseDTO();
    response.setAccessToken(jwtUtil.generateToken(buildUserDetails(user)));
    return response;
  }

  private UserDetails buildUserDetails(User user) {
    return new UserDTO().setUsername(user.getLogin()).setPassword(user.getPassword());
  }

}
