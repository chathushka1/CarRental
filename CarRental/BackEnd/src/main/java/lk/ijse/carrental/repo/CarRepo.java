package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 19:35
 * 2023-10-29
 * FrontEnd
 */
public interface CarRepo extends JpaRepository<Car, String> {
    @Query(value = "SELECT vId FROM Car ORDER BY vId Desc LIMIT 1",nativeQuery = true)
    String generateVId();

    @Query(value = "SELECT COUNT(*) FROM Car",nativeQuery = true)
    int registeredVehicleCount();

    @Query(value = "SELECT * FROM Car WHERE registeredDate=:date",nativeQuery = true)
    int dailyRegisteredVehicleCount(@Param("date") String date);

    @Query(value = "SELECT * FROM Car WHERE vId = :id",nativeQuery = true)
    Customer searchVehicle(@Param("id")String id);

    @Query(value = "SELECT * FROM Car WHERE vRegisterNumber=:vRegisterNumber",nativeQuery = true)
    Customer findVehicleToReserve(@Param("vRegisterNumber")String vRegisterNumber);
}
