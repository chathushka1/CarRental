package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.UserDTO;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 22:12
 * 2023-10-29
 * FrontEnd
 */
public interface UserService {
    void saveUser(UserDTO usersDTO);

    void updateUser(UserDTO usersDTO);

    void deleteUser(String id);

    UserDTO searchUser(String id);

    List<UserDTO> getAllUsers();

    String generateUserIds();

    UserDTO findByPasswordAndUsername(String password, String username);

    UserDTO findByUsername(String username);
}
