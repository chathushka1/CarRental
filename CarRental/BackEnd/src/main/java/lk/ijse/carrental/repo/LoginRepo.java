package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 21:18
 * 2023-10-29
 * FrontEnd
 */
public interface LoginRepo extends JpaRepository<Login, String> {

    @Query(value = "SELECT loginId FROM Login ORDER BY loginId DESC LIMIT 1",nativeQuery = true)
    String getLastLoginId();
}
