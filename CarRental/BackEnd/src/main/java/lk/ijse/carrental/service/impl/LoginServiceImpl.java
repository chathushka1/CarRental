package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.LoginDTO;
import lk.ijse.carrental.repo.LoginRepo;
import lk.ijse.carrental.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 21:26
 * 2023-10-29
 * FrontEnd
 */

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveLogData(LoginDTO dto) {

    }

    @Override
    public String generateLoginId() {
        return null;
    }

    @Override
    public String getLastLoginId() {
        return null;
    }

    @Override
    public LoginDTO searchLogin(String loginId) {
        return null;
    }
}
