package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.AdminDTO;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:12
 * 2023-11-02
 * FrontEnd
 */
public interface AdminService {
    void saveAdmin(AdminDTO dto);

    void updateAdmin(AdminDTO dto);

    void deleteAdmin(String id);

    boolean findAdminByUserName(String username);

    boolean findAdminByPassWord(String password);

    List<AdminDTO> getAllAdmins();

    String generateAdminId();
}
