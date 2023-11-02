package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.LoginDTO;
import lk.ijse.carrental.entity.Login;
import lk.ijse.carrental.repo.LoginRepo;
import lk.ijse.carrental.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:02
 * 2023-11-02
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
        if (!repo.existsById(dto.getLoginId())) {
            repo.save(mapper.map(dto, Login.class));
        } else {
            throw new RuntimeException("Login Already Exists");
        }
    }

    @Override
    public String generateLoginId() {
        String lastId = repo.getLastLoginId();
        String id = "";

        if (lastId != null) {
            int tempId = Integer.parseInt(lastId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                id = "Log-000" + tempId;
            } else if (tempId <= 99) {
                id = "Log-00" + tempId;
            } else if (tempId <= 999) {
                id = "Log-0" + tempId;
            } else if (tempId <= 9999) {
                id = "Log-" + tempId;
            }
        } else {
            id = "Log-0001";
        }
        return id;
    }

    @Override
    public String getLastLoginId() {
        return repo.getLastLoginId();
    }

    @Override
    public LoginDTO searchLogin(String loginId) {
        if (repo.existsById(loginId)) {
            return mapper.map(repo.findById(loginId).get(), LoginDTO.class);
        } else {
            throw new RuntimeException("Login Not Found...");
        }
    }
}
