package lk.ijse.carrental.repo;


import lk.ijse.carrental.entity.Driver;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 18:48
 * 2023-10-29
 * FrontEnd
 */
public interface DriverRepo {

    @Query(value = "SELECT dId FROM Driver ORDER BY dId Desc LIMIT 1",nativeQuery = true)
    String generateDId();

    @Query(value = "SELECT COUNT(*) FROM Driver",nativeQuery = true)
    int registeredDriverCount();

    @Query(value = "SELECT * FROM Driver WHERE registeredDate=:date",nativeQuery = true)
    int dailyRegisteredDriverCount(@Param("date") String date);

    @Query(value = "SELECT * FROM Driver WHERE dId = :id",nativeQuery = true)
    Driver searchDriver(@Param("id")String id);

}
