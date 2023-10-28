package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:04
 * 2023-10-25
 * FrontEnd
 */
public interface CustomerRepo extends JpaRepository<Customer,String>{

    @Query(value = "SELECT cId FROM Customer ORDER BY cId Desc LIMIT 1",nativeQuery = true)
    String generateCId();

    @Query(value = "SELECT COUNT(*) FROM Customer",nativeQuery = true)
    int registeredCusCount();

    @Query(value = "SELECT * FROM Customer WHERE registeredDate=:date",nativeQuery = true)
    int dailyRegisteredCusCount(@Param("date") String date);

    @Query(value = "SELECT * FROM Customer WHERE users_userId = :id",nativeQuery = true)
    Customer searchCustomer(@Param("id")String id);
}
