package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 22:08
 * 2023-10-29
 * FrontEnd
 */
public interface UserRepo extends JpaRepository<User,String> {

    @Query(value = "SELECT userId FROM User ORDER BY userId DESC LIMIT 1", nativeQuery = true)
    String generateUserId();

    User findByPasswordAndUsername(String password, String username);

    User findByUsername(String username);
}
