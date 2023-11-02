package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:11
 * 2023-11-02
 * FrontEnd
 */
public interface AdminRepo  extends JpaRepository<Admin, String> {
    Optional<Admin> findAdminByUsername(String username);
    Optional<Admin> findAdminByPassword(String password);

    @Query(value = "SELECT adminId FROM Admin ORDER BY adminId DESC LIMIT 1",nativeQuery = true)
    String generateAdminId();
}
