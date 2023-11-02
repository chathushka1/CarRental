package lk.ijse.carrental.repo;

import org.springframework.data.jpa.repository.Query;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:00
 * 2023-11-02
 * FrontEnd
 */
public interface LoginRepo {
    @Query(value = "SELECT loginId FROM Login ORDER BY loginId DESC LIMIT 1",nativeQuery = true)
    String getLastLoginId();
}
