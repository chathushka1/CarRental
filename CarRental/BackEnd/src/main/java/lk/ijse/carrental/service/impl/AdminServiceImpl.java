package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.AdminDTO;
import lk.ijse.carrental.entity.Admin;
import lk.ijse.carrental.repo.AdminRepo;
import lk.ijse.carrental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:13
 * 2023-11-02
 * FrontEnd
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (!repo.existsById(dto.getAdminId())) {
            repo.save(mapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("Admin Already Exists");
        }
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getAdminId())) {
            repo.save(mapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("No Such Admin to update");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No Such Admin To Delete");
        }
    }

    @Override
    public boolean findAdminByUserName(String username) {
        return repo.findAdminByUsername(username).isPresent();
    }

    @Override
    public boolean findAdminByPassWord(String password) {
        return repo.findAdminByPassword(password).isPresent();
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return mapper.map(repo.findAll(), new TypeToken<List<AdminDTO>>() {
        }.getType());
    }

    @Override
    public String generateAdminId() {
        String lastId = repo.generateAdminId();
        String id = "";

        if (lastId != null) {
            int tempId = Integer.parseInt(lastId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                id = "Ad-00" + tempId;
            } else if (tempId <= 99) {
                id = "Ad-0" + tempId;
            } else if (tempId <= 999) {
                id = "Ad-" + tempId;
            }
        } else {
            id = "Ad-001";
        }
        return id;
    }
}
