package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.LoginDTO;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 19:50
 * 2023-10-29
 * FrontEnd
 */
public interface LoginService {
    void saveLogData(LoginDTO dto);

    String generateLoginId();

    String getLastLoginId();

    LoginDTO searchLogin(String loginId);
}
