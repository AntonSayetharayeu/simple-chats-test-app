package testapp.service.interfaces;

import testapp.dto.request.LoginDTO;
import testapp.dto.request.RegisterDTO;
import testapp.dto.request.UserUpdateDTO;
import testapp.dto.responce.LoggedUserDTO;
import testapp.dto.responce.UserDTO;
import testapp.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    List<UserDTO> findAllUsers();

    Optional<User> findUserById(Long id);

    UserDTO createUser(RegisterDTO dto);

    Optional<LoggedUserDTO> authenticateUser(LoginDTO dto);

    UserDTO updateUser(Long id, UserUpdateDTO dto);

    boolean deleteUserById(Long id);
}
