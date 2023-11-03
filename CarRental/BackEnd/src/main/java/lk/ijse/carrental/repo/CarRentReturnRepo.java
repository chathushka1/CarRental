package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.CarRentReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 20:05
 * 2023-11-03
 * FrontEnd
 */
public interface CarRentReturnRepo extends JpaRepository<CarRentReturn,String> {
    @Query(value = "SELECT returnId FROM CarRentReturn ORDER BY returnId DESC LIMIT 1", nativeQuery = true)
    String generateReturnId();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CarRentReturn VALUES (:returnId,:date,:noOfKm,:paymentId,:rentId)", nativeQuery = true)
    void saveCarRentReturn(@Param("returnId") String returnId, @Param("date") String date, @Param("noOfKm") double noOfKm, @Param("paymentId") String paymentId, @Param("rentId") String rentId);
}

