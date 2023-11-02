package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.LoginDTO;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:01
 * 2023-11-02
 * FrontEnd
 */
public interface LoginService {
    void saveLogData(LoginDTO dto);

    String generateLoginId();

    String getLastLoginId();

    LoginDTO searchLogin(String loginId);
}
