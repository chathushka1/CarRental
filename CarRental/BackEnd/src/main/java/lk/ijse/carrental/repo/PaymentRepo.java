package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:42
 * 2023-11-02
 * FrontEnd
 */
public interface PaymentRepo extends JpaRepository<Payment, String> {
    @Query(value = "SELECT * FROM Payment WHERE date BETWEEN :fromDate AND :toDate", nativeQuery = true)
    List<Payment> getAllPaymentsByDateRange(@Param("fromDate") String fromDate, @Param("toDate") String toDate);


    @Query(value = "SELECT * FROM Payment WHERE customerId=:customerId", nativeQuery = true)
    List<Payment> getAllPaymentsByCustomerId(@Param("customerId") String customerId);

    @Query(value = "SELECT paymentId FROM Payment ORDER BY paymentId DESC LIMIT 1", nativeQuery = true)
    String generatePaymentId();

    boolean existsByRentalRentId(String rentId);

    /*@Query(value = "DELETE FROM Payment WHERE rentID=:rentID",nativeQuery = true)
    void deletePaymentByRentId(@Param("rentID") String rentID);*/

    void deleteAllByRentalRentId(String rentID);

    @Query(value = "SELECT SUM(amount) FROM Payment WHERE rentID=:rentID",nativeQuery = true)
    double getSumOfPaidPayments(@Param("rentID") String rentID);

    @Query(value = "SELECT SUM(amount) FROM Payment WHERE date BETWEEN :fromDate AND :toDate",nativeQuery = true)
    double getSumOfPaymentAmount(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
}
